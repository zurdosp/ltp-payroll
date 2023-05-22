package com.ltp.payroll.bean;

import java.util.Date;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "PayRollParams")
@Getter @Setter
public class PayRollResult {

	private String employeeId;
	
	private Date processDate;
	
	/**
	 * Map with key: id of budget and value: the result of process
	 */
	private Map<String, Object> budgetResult; 
	
}
