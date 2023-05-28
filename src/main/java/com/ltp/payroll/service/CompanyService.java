package com.ltp.payroll.service;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltp.payroll.bean.Company;
import com.ltp.payroll.bean.Employee;
import com.ltp.payroll.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository repository;

	public Optional<Company> getCompany(ObjectId objectId) {
		return repository.findById(objectId);
	}

	public Company createCompany(Company company) {
		return repository.save(company);
	}
	
}
