package com.ltp.payroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltp.payroll.bean.Employee;
import com.ltp.payroll.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	public List<Employee> findAllEmployees(){
		return repository.findAll();
	}
	
	public Employee createEmployee(Employee employee) {
		return repository.save(employee);
	}
	
}
