package com.ltp.payroll.enums;

import lombok.Getter;

@Getter
public enum BudgetOperatorEnum {
	ADD("ADD", "ADD"),
	DEDUCTION("DEDUCTION", "DEDUCTION"),
	INFORMATIVE("INFORMATIVE", "INFORMATIVE");
	
	private String name;
	
	private String description;

	private BudgetOperatorEnum(String name, String description) {
		this.name = name;
		this.description = description;
	}

	
}
