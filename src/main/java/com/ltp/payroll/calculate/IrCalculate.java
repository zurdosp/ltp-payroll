package com.ltp.payroll.calculate;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ltp.payroll.bean.Budget;
import com.ltp.payroll.bean.Company;
import com.ltp.payroll.bean.Employee;
import com.ltp.payroll.bean.GenericConfig;


public class IrCalculate {

	private Logger logger = LoggerFactory.getLogger(IrCalculate.class); 

	public BigDecimal calculateV2(Employee employee, Budget budget, 
			Company company, GenericConfig genericconfig) {
		
		return new BigDecimal(0);
	}
	
	public BigDecimal calculate(Employee employee, Budget budget, 
			Company company, GenericConfig genericconfig) {

		Double salario = employee.getSalary().doubleValue();
		logger.info("Calculando o IR para salario: {}", employee.getSalary());

		//aliquotas
		double aliquota1 = 0.075;
		double aliquota2 = 0.15;
		double aliquota3 = 0.225;
		double aliquota4 = 0.275;

		//parcelas redutoras
		double parcelaRedutora1 = 158.40;
		double parcelaRedutora2 = 370.40;
		double parcelaRedutora3 = 651.73;
		double parcelaRedutora4 = 884.96;

		if (salario <= 2112.00) {
			logger.info("nao ha deducao fiscal");

		} else if (salario >= 2112.01 && salario <= 2826.65) {
			logger.info("A deducao fiscal e de 7.5%");
			return new BigDecimal(salario * aliquota1 - parcelaRedutora1);

		} else if (salario >= 2826.65 && salario <= 3751.05) {
			logger.info("A deducao fiscal e de 15%");
			return new BigDecimal(salario * aliquota2 - parcelaRedutora2);

		} else if (salario >= 3751.06 && salario <= 4664.68) {
			logger.info("A deducao fiscal e de 22,5%");
			return new BigDecimal (salario * aliquota3 - parcelaRedutora3);

		} else
			logger.info("A deducao fiscal e de 27,5%");
		return new BigDecimal (salario * aliquota4 - parcelaRedutora4);

	}
}
