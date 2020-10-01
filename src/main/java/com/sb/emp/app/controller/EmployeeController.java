package com.sb.emp.app.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.emp.app.exception.ResourceNotFoundException;
import com.sb.emp.app.model.Employee;
import com.sb.emp.app.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl empService;

	@PostMapping("/employees")
	@Transactional
	public List<Employee> saveAllStudent(@Valid @RequestBody List<Employee> empList) throws ResourceNotFoundException {
		List<Employee> response = (List<Employee>) empService.saveAll(empList);
		return response;
	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") long id, @Valid @RequestBody Employee employee) throws ResourceNotFoundException  {
		employee.setId(id);
		return ResponseEntity.ok().body(this.empService.updateEmployee(employee));
	}

}
