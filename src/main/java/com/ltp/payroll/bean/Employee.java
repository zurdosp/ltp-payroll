package com.ltp.payroll.bean;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "employees")
@Getter @Setter
public class Employee {

	private String id;
	
	private String name;
	
	private Date birthDate;
	
	private String identification;
	
	private BigDecimal salary;
	
	private Integer monthWorkedQuantity;
	
}
