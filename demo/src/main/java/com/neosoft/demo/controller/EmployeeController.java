package com.neosoft.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.demo.Response.ResponsePayload;
import com.neosoft.demo.exception.ResourceNotFoundException;
import com.neosoft.demo.model.Employee;

import com.neosoft.demo.service.EmployeeService;



@RestController 
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<ResponsePayload> getEmployeeById(@PathVariable(value = "id") Long employeeId)
        throws ResourceNotFoundException {
    	ResponsePayload responsePayload=new ResponsePayload();
    	try {
    		
    		Employee employee = employeeService.findById(employeeId);  
    		responsePayload.setData(employee);
    		responsePayload.setMessage("Get Employee Successfully");
            return ResponseEntity.ok().body(responsePayload);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(e.getMessage());
		}
        
    }
    
    @PostMapping("/employees")
    public ResponseEntity<ResponsePayload> createEmployee(@RequestBody Employee employee) throws ResourceNotFoundException {
    	ResponsePayload responsePayload=new ResponsePayload();

    	try {
        	employeeService.save(employee);
    		responsePayload.setData(employee);
    		responsePayload.setMessage("Create Employee Successfully");
            return ResponseEntity.ok().body(responsePayload);
		} catch (Exception e) {
			e.printStackTrace();;
    		responsePayload.setData(e.getMessage());
    		responsePayload.setMessage("Failed To Create");
            return ResponseEntity.ok().body(responsePayload);
		}
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<ResponsePayload> updateEmployee(@PathVariable(value = "id") Long employeeId,
          @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
    	ResponsePayload responsePayload=new ResponsePayload();
    	try {
            Employee employee = employeeService.findById(employeeId);        

            employee.setEmailId(employeeDetails.getEmailId());
            employee.setLastName(employeeDetails.getLastName());
            employee.setFirstName(employeeDetails.getFirstName());
            
            final Employee updatedEmployee = employeeService.save(employee); 
            
            responsePayload.setData(updatedEmployee);
    		responsePayload.setMessage("Update Employee Successfully");
            
            return ResponseEntity.ok(responsePayload);
		} catch (Exception e) {
			e.printStackTrace();;
    		responsePayload.setData(e.getMessage());
    		responsePayload.setMessage("Failed To Update");
            return ResponseEntity.ok().body(responsePayload);
		}
    	

    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<ResponsePayload> deleteEmployee(@PathVariable(value = "id") Long employeeId)
         throws ResourceNotFoundException {
    	ResponsePayload responsePayload=new ResponsePayload();
    	try {
    		Employee employee = employeeService.findById(employeeId);
    		int i=employeeService.deleteEmployee(employee);
    		if(i==1) {
        		responsePayload.setData(employee);
        		responsePayload.setMessage("Delete Successfully");
                return ResponseEntity.ok().body(responsePayload);
    		}else {
        		responsePayload.setData(employee);
        		responsePayload.setMessage("Delete Failed!!");
                return ResponseEntity.ok().body(responsePayload);
    		}

		} catch (Exception e) {
			responsePayload.setData("Error");
    		responsePayload.setMessage("Delete Failed!!");
            return ResponseEntity.ok().body(responsePayload);
		}
       
    }
}
