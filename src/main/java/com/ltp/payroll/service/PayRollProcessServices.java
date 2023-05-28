package com.ltp.payroll.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltp.payroll.bean.Budget;
import com.ltp.payroll.bean.BudgetResult;
import com.ltp.payroll.bean.Company;
import com.ltp.payroll.bean.Employee;
import com.ltp.payroll.bean.GenericConfig;
import com.ltp.payroll.bean.PayRollParams;
import com.ltp.payroll.bean.PayRollResult;
import com.ltp.payroll.proxy.PayrollProxy;

@Service
public class PayRollProcessServices {
	
	private Logger logger = LoggerFactory.getLogger(PayRollProcessServices.class); 
	
	@Autowired
	private PayrollProxy payrollProxy;
	
	public List<PayRollResult> processPayroll(final PayRollParams payRollParams){
		logger.info("processing company id {}", payRollParams.getCompanyId());
		List<PayRollResult> list = new ArrayList<PayRollResult>(); 
		List<Budget> budgets = payrollProxy.getAllBudgets();
		List<Employee> employess = payrollProxy.getAllEmployees();
		Company company = payrollProxy.getCompany(payRollParams.getCompanyId());
		logger.info("getting company id {} and name {}", payRollParams.getCompanyId(), company.getName());
		processBudgetXEmployee(list, budgets, employess, company);
		return list;
	}

	public List<Employee> getAllEmployees(){
		return payrollProxy.getAllEmployees();
	}

	private void processBudgetXEmployee(List<PayRollResult> list, List<Budget> budgets, List<Employee> employess, Company company) {
		for (Employee employee : employess) {
			PayRollResult payRollResult = new PayRollResult();
			setDataPayRollResult(payRollResult, employee);
			
			List<BudgetResult> budgetResultList = new ArrayList<BudgetResult>();
			int countBudgetResult = 0;
			for (Budget budget : budgets) {
				if (!budget.getStatus().equalsIgnoreCase("ATIVO")) continue; 
				BudgetResult budgetResult = new BudgetResult();
				BigDecimal finalValue = new BigDecimal(0);
				try {
					switch (budget.getType()) {
						case "VALUE" -> finalValue = processSpecificCalcBudgetValue(employee, budget, company, new GenericConfig(),
								budget.getClassNameCalculator());
						case "PERCENTAGE" -> finalValue = employee.getSalary().multiply(budget.getValue().divide(BigDecimal.valueOf(100)));
					}
					logger.info("Final value processed {} for budget name: {} using calc Class {}", finalValue, budget.getName(), budget.getClassNameCalculator());
					processBudgetResult(budget, budgetResult, finalValue, payRollResult);
					budgetResult.setIdPayRollResult(String.valueOf(++countBudgetResult));
					budgetResultList.add(budgetResult);
					logger.info("Genarated budget value for employee {}, key budget: {}, value budget: {}", 
							employee.getId(), budget.getType(), finalValue);
				} catch (Exception e) {
					logger.error("Error trying to process payroll for employee {}", employee.getId());
					throw new IllegalArgumentException("Unexpected value: " + budget.getType());
				}

			}
			payRollResult.setBudgetResultList(budgetResultList);
			list.add(payRollResult);
		}
	}

	private BigDecimal processSpecificCalcBudgetValue(Employee employee, Budget budget, Company company, 
			GenericConfig genericConfig, String classNameCalculator) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		if (classNameCalculator == null || "".equalsIgnoreCase(classNameCalculator)) {
			return budget.getValue();
		}
		try {
			Class<?> clazz = Class.forName(classNameCalculator);
			//Method method = clazz.getMethod("calculate", Double.class);
			Method method = clazz.getMethod("calculate", Employee.class, Budget.class, Company.class, GenericConfig.class);
			return (BigDecimal)method.invoke(clazz.getDeclaredConstructor().newInstance(), employee, budget, company, new GenericConfig());
		} catch (Exception e) {
			logger.error("Error trying to process specific calculation", e);
		} 
		return budget.getValue();
	}

	private void processBudgetResult(Budget budget, BudgetResult budgetResult, BigDecimal finalValue, PayRollResult payRollResult) {
		budgetResult.setName(budget.getName());
		budgetResult.setResult(finalValue);
		budgetResult.setBudgetOperatorEnum(budget.getBudgetOperatorEnum());
		budgetResult.setType(budget.getType());
		budgetResult.setValue(budget.getValue());
		budgetResult.setClassNameCalculator(budget.getClassNameCalculator());
		if (budget.getBudgetOperatorEnum().getName().equals("ADD")) {
			payRollResult.setAdds(payRollResult.getAdds().add(finalValue));
		} else if (budget.getBudgetOperatorEnum().getName().equals("DEDUCTION")) {
			payRollResult.setDiscounts(payRollResult.getDiscounts().add(finalValue));
		}
	}
	


	private void setDataPayRollResult(PayRollResult payRollResult, Employee employee) {
		payRollResult.setEmployeeId(employee.getId());
		payRollResult.setProcessDate(new Date());
		payRollResult.setNetSalary(employee.getSalary());
		payRollResult.setEmployeeName(employee.getName());
		payRollResult.setIdentification(employee.getIdentification());
	}
}
