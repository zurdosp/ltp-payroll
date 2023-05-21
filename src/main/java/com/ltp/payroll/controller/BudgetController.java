package com.ltp.payroll.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.payroll.bean.Budget;
import com.ltp.payroll.service.BudgetService;

@RestController
public class BudgetController {
	
	private Logger logger = LoggerFactory.getLogger(BudgetController.class); 

	
	@Autowired
	private BudgetService budgetService;
	
	@Autowired
	private Environment environment;
	
	@PostMapping("/budget")
	public ResponseEntity<Object> createBudget(@RequestBody Budget budget) {
		logger.info("createBudget called with {} to {}", "", "");
		budgetService.createBurget(budget);
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}

	
	@GetMapping("/budget")
	public List<Budget> listBudget() {
		logger.info("listBudget called with {} to {}", "", "");
		return budgetService.findAllBudgets();
	}
	
	
}
