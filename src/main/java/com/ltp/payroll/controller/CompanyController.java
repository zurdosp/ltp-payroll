package com.ltp.payroll.controller;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.payroll.bean.Company;
import com.ltp.payroll.service.CompanyService;

import jakarta.validation.Valid;

@RestController
public class CompanyController {

	private Logger logger = LoggerFactory.getLogger(CompanyController.class); 
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/company/{id}")
	public Optional<Company> getCompany(@PathVariable String id){
		logger.info("getCompany called with id: {}", id);
		return companyService.getCompany(new ObjectId(id));
	}
	
	@PostMapping("/company")
	public ResponseEntity<Object> createCompany(@Valid @RequestBody Company company){
		logger.info("Company called with company data", company.toString());
		companyService.createCompany(company);
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
}
