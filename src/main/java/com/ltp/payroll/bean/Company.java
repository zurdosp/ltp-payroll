package com.ltp.payroll.bean;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "company")
@Getter @Setter
public class Company {

	private String id;
	
	private String name;
	
	private Date fundationDate;
	
	private String identification;
	
}
