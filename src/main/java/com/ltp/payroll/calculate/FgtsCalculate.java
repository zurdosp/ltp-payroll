package com.ltp.payroll.calculate;

import java.math.BigDecimal;

import com.ltp.payroll.bean.Budget;
import com.ltp.payroll.bean.Company;
import com.ltp.payroll.bean.Employee;
import com.ltp.payroll.bean.GenericConfig;

public class FgtsCalculate {
	
	public BigDecimal calculate(Employee employee, Budget budget, 
			Company company, GenericConfig genericconfig) {
		return employee.getSalary().multiply(new BigDecimal(0.08));
	}

}
