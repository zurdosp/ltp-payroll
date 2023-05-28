package com.ltp.payroll.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ltp.payroll.bean.Budget;
import com.ltp.payroll.bean.Company;
import com.ltp.payroll.bean.Employee;

@FeignClient(name="ltp-payroll")
public interface PayrollProxy {
	
	@RequestMapping( method = RequestMethod.GET, value = "/budget", consumes = "application/json")
	public List<Budget> getAllBudgets();
	
	@RequestMapping( method = RequestMethod.GET, value = "/employee", consumes = "application/json")
	public List<Employee> getAllEmployees();
	
	@RequestMapping( method = RequestMethod.GET, value = "/company/{id}", consumes = "application/json")
	public Company getCompany(@PathVariable("id") String id);
	
	
}
