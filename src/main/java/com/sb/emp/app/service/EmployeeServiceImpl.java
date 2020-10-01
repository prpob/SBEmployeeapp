package com.sb.emp.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.emp.app.dao.EmployeeRepository;
import com.sb.emp.app.exception.ResourceNotFoundException;
import com.sb.emp.app.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> saveAll(Iterable<Employee> entities) throws ResourceNotFoundException {
		List<Employee> list = empRepo.saveAll(entities);
		return list;
	}

	@Override
	public Employee updateEmployee(Employee entity) throws ResourceNotFoundException  {
		Optional<Employee> empdb = empRepo.findById(entity.getId());


		if (empdb.isPresent()) {
			Employee temp = empdb.get();
			temp.setName(entity.getName());
			temp.setSalary(entity.getSalary());
			temp.setDob(entity.getDob());
			temp.setDesignation(entity.getDesignation());
			temp.setAddress(entity.getAddress());
			temp.setBloodGrp(entity.getBloodGrp());

			final Employee updatedEmployee = empRepo.save(entity);
			return updatedEmployee;

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + entity.getId());
		}

	}

}
