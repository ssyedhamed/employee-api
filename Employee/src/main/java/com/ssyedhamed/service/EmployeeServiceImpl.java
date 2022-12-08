package com.ssyedhamed.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssyedhamed.dao.EmployeeDao;
import com.ssyedhamed.entities.Employee;
import com.ssyedhamed.exceptions.ResourceNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao empDao;
	@Override
	public Employee saveEmployee(Employee e) {
		this.empDao.save(e);
		return e;
	}

	@Override
	public List<Employee> getEmployees() {
		return this.empDao.findAll();
		
	}

	@Override
	public Employee getEmployee(long id) throws ResourceNotFoundException{
		return this.empDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee doesn't exist"));
	}

	@Override
	public Employee updateEmployee(Employee e, long id) {
		Employee employee=this.empDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee doesn't exist in the database"));		
			employee.setName(e.getName());
			employee.setRole(e.getRole());
			employee.setAbout(e.getAbout());
			employee.setExperience(e.getExperience());
			employee.setJoiningDate(e.getJoiningDate());
			this.saveEmployee(employee);
		return e;
		
	}

	@Override
	public void deleteEmployee(long id) {
		
		Optional<Employee> emp=this.empDao.findById(id);
		if(emp.isPresent()) {
			this.empDao.delete(emp.get());
		}
		
	}

}
