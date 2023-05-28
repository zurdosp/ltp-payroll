package com.ltp.payroll.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.payroll.bean.PayRollParams;
import com.ltp.payroll.bean.PayRollResult;
import com.ltp.payroll.service.PayRollProcessServices;

@RestController
public class PayRollController {
	
	private Logger logger = LoggerFactory.getLogger(PayRollController.class); 
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private PayRollProcessServices payRollProcessServices;
	
	@GetMapping("/payroll")
	public void getPayrolls() {
		logger.info("payroll called with {} to {}", "", "");
	}

	@PostMapping("/payroll")
	public void generatePayroll() {
		logger.info("generatePayroll called with {} to {}", "", "");
	}
	
	@PostMapping("/process-payroll")
	public List<PayRollResult> processPayroll(@RequestBody PayRollParams payRollParams) {
		logger.info("processPayroll called with {} to {}", "", "");
		return payRollProcessServices.processPayroll(payRollParams);

	}
}
