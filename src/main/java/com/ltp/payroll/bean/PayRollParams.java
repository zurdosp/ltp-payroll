package com.ltp.payroll.bean;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "PayRollParams")
@Getter @Setter
public class PayRollParams {
	
	private String companyId;
	
}
