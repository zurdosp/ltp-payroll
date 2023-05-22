package com.ltp.payroll.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.ltp.payroll.bean.Employee;

@FeignClient(name="ltp-payroll", url = "http://localhost:8000")
public interface EmployeeProxy {
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployees();
}
