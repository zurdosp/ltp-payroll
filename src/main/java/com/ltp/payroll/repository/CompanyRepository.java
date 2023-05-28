package com.ltp.payroll.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ltp.payroll.bean.Company;

public interface CompanyRepository  extends MongoRepository<Company, ObjectId>{

}
