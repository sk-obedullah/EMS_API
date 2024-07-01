package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.customexception.BusinessException;
import com.ems.customexception.ControllerException;
import com.ems.model.Employee;
import com.ems.model.Vendor;
import com.ems.service.EmployeeService;
import com.ems.serviceImpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp")
@CrossOrigin(origins = "*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		try {
			Employee empDetails = this.employeeService.createEmployee(employee);
			return new ResponseEntity<Employee>(empDetails,HttpStatus.ACCEPTED);
		}catch(BusinessException e){
			ControllerException ce = new ControllerException(e.getMessage());
			return new ResponseEntity<>(ce.getMessage(),HttpStatus.BAD_REQUEST);	
		}catch (ControllerException e) {
			ControllerException ce =new ControllerException("Something wrong in controller");
			return new ResponseEntity<>(ce,HttpStatus.BAD_REQUEST);
		}
		 
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllVendors() {
		try {
			List<Employee> employeeDetails = this.employeeService.getAllEmployees();
			return new ResponseEntity<>(employeeDetails,HttpStatus.ACCEPTED);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getMessage());
			return new ResponseEntity<>(ce.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (ControllerException e) {
			ControllerException ce = new ControllerException("Something wrong in controller");
			return new ResponseEntity<>(ce, HttpStatus.BAD_REQUEST);

		}
	}
	
	

}
