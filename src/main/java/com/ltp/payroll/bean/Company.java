package com.ltp.payroll.bean;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.ltp.payroll.validation.ContactNumberConstraint;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "company")
@Getter @Setter
public class Company {

	private String id;
	
	@NotNull(message = "name cannot be nulll")
	@NotBlank
	private String name;
	
	@NotNull
	private Date fundationDate;
	
	@NotNull
	private String identification;
	
	@ContactNumberConstraint
	private String contactNumber;
	
}
