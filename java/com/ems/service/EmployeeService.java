package com.ems.service;

import com.ems.model.Employee;

import java.util.*;

public interface EmployeeService {
	
	public Employee createEmployee(Employee employee);
	public Employee getEmployee(int id);
	public List<Employee> getAllEmployees();

}
