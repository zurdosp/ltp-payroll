package com.ltp.payroll.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.ltp.payroll.enums.BudgetOperatorEnum;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "BudgetResult")
@Getter @Setter
public class BudgetResult {

	private String  idPayRollResult;
	
	private String name;
	
	private String type;
	
	private BigDecimal value;
	
	private BigDecimal result;
	
	private BudgetOperatorEnum budgetOperatorEnum;
	
	private String classNameCalculator;
	
}
