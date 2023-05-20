package com.ltp.payroll.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ltp.payroll.bean.Budget;

public interface BudgetRepository  extends MongoRepository<Budget, Long>{

}
