package com.ltp.payroll.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ltp.payroll.bean.Budget;
import com.ltp.payroll.bean.Employee;

public interface EmployeeRepository  extends MongoRepository<Employee, Long>{

}
