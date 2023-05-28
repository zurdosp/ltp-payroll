package com.ltp.payroll.bean;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "employees")
@Getter @Setter
public class GenericConfig {

	private String id;
	
	private String name;
	
	private String value;
	
	private String type;
	
}
