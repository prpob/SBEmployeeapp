package com.sb.emp.app.service;

import java.util.List;

import com.sb.emp.app.exception.ResourceNotFoundException;
import com.sb.emp.app.model.Employee;

public interface IEmployeeService {
	
	List<Employee> saveAll(Iterable<Employee> entities) throws ResourceNotFoundException;
	Employee updateEmployee(Employee entity) throws ResourceNotFoundException;

}
