package com.ltp.payroll.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayRollController {
	
	private Logger logger = LoggerFactory.getLogger(PayRollController.class); 
	
	
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/payroll")
	public void getPayrolls() {
		logger.info("payroll called with {} to {}", "", "");
	}

	@PostMapping("/payroll")
	public void generatePayroll() {
		logger.info("generatePayroll called with {} to {}", "", "");
	}
	
}
