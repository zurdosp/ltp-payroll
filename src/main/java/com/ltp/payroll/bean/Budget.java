package com.ltp.payroll.bean;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

import com.ltp.payroll.enums.BudgetOperatorEnum;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "budgets")
@Getter @Setter
public class Budget {

	private String id;
	
	private String description;
	
	private String idPayRoll;
	
	private String name;
	
	private String type;
	
	private BigDecimal value;
	
	private String status;
	
	private BudgetOperatorEnum budgetOperatorEnum;
	
	private String classNameCalculator;
	
	
}
