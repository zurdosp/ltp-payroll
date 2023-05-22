package com.ltp.payroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltp.payroll.bean.Employee;
import com.ltp.payroll.proxy.EmployeeProxy;

@Service
public class PayRollServices {
	
	@Autowired
	private EmployeeProxy employeeProxy; 
	
	public List<Employee> getAllEmployees(){
		return employeeProxy.getAllEmployees();
	}

}
