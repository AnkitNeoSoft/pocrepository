package com.neosoft.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.demo.model.Employee;
import com.neosoft.demo.repository.EmployeeMongoRepository;


@Service
public class EmployeeMongoDbSevice {
	
    @Autowired
    private EmployeeMongoRepository employeeRepository;
    
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long employeeId) {
    	Employee emp=null;
    	try {
        	emp=employeeRepository.findById(employeeId).orElse(null);
    		return emp;
		} catch (Exception e) {
			e.printStackTrace();
			return emp;
		}

    }
    public Employee save(Employee emp) {
    	Employee employee=null;
    	try {
        	employee=employeeRepository.save(emp);
        	return employee;
		} catch (Exception e) {
			e.printStackTrace();
			return employee;
		}

    }
    
    public int deleteEmployee(Employee emp) {
    	int i=0;
    	try {
    		employeeRepository.delete(emp);
    		i=1;
    		return i;
		} catch (Exception e) {
			return i;
		}
    	
		
    }
}
