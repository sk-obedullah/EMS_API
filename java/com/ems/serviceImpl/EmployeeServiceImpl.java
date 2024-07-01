package com.ems.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.customexception.BusinessException;
import com.ems.model.Employee;
import com.ems.model.Vendor;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {

		if (employee.getName() == "") {
			throw new BusinessException("Please Enter Name");
		} else if (employee.getCtc() == 0) {
			throw new BusinessException("Please Enter CTC");
		} else if (employee.getDesignation() == "") {
			throw new BusinessException("Please Enter Designation");
		} else if (employee.getEmail() == "") {
			throw new BusinessException("Please Enter Email");
		} else if (employee.getDesignation() != "") {
			Employee isEmail = this.employeeRepository.findByEmail(employee.getEmail());
			if (isEmail != null) {
				throw new BusinessException("Email already exist");
			}
		} 
		return this.employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		try {
			List<Employee> allEmoloyees = this.employeeRepository.findAll();
			return allEmoloyees;
		}catch(Exception e ) {
			throw new BusinessException(e.getMessage());
		}
	}

}
