package com.ltp.payroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltp.payroll.bean.Budget;
import com.ltp.payroll.repository.BudgetRepository;

@Service
public class BudgetService {
	
	@Autowired
	private BudgetRepository repository;

	public List<Budget> findAllBudgets(){
		return repository.findAll();
	}
	
}
