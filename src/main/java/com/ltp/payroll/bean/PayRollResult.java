package com.ltp.payroll.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "PayRollParams")
@Getter @Setter
public class PayRollResult {

	private String employeeId;

	private String employeeName;
	
	private String identification;
	
	private Date processDate;
	
	private BigDecimal netSalary = new BigDecimal(0);
	
	private BigDecimal adds = new BigDecimal(0);
	
	private BigDecimal discounts = new BigDecimal(0);
	
	/**
	 * Map with key: id of budget and value: the result of process
	 */
	private List<BudgetResult> budgetResultList; 
	
}
