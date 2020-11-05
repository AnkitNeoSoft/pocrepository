package com.neosoft.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.demo.model.Employee;
@Repository
public interface EmployeeMongoRepository extends MongoRepository<Employee,Long> {
	
	 List<Employee> findAll() ;

}
