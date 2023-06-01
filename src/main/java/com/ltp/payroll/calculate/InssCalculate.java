package com.ltp.payroll.calculate;

import java.math.BigDecimal;

import com.ltp.payroll.bean.Budget;
import com.ltp.payroll.bean.Company;
import com.ltp.payroll.bean.Employee;
import com.ltp.payroll.bean.GenericConfig;

public class InssCalculate {

	public BigDecimal calculate(Employee employee, Budget budget, 
			Company company, GenericConfig genericconfig) {

		if(faixaSalarial(employee.getSalary(),new BigDecimal(1693.72)))
			return employee.getSalary().multiply(new BigDecimal(8)).divide(new BigDecimal(100));
		else if(faixaSalarial(employee.getSalary(), new BigDecimal(2822.90)))
			return employee.getSalary().multiply(new BigDecimal(9)).divide(new BigDecimal(100));
		else
			return employee.getSalary().multiply(new BigDecimal(11)).divide(new BigDecimal(100));
	}
	
	

	private boolean faixaSalarial(BigDecimal salario, BigDecimal menorValor){
		return salario.compareTo(menorValor) <= 0;
	}
}
