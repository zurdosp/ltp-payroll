package com.ltp.payroll.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.payroll.bean.Employee;
import com.ltp.payroll.service.EmployeeService;

@RestController
public class EmployeeController {

	private Logger logger = LoggerFactory.getLogger(BudgetController.class); 
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> listEmployee(){
		logger.info("listEmployee called with {} to {}", "", "");
		return employeeService.findAllEmployees();
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee){
		logger.info("createEmployee called with {} to {}", "", "");
		employeeService.createEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
}
