package com.ssyedhamed.service;

import java.util.List;

import com.ssyedhamed.entities.Employee;

public interface EmployeeService {
	public Employee saveEmployee(Employee e);
	public List<Employee> getEmployees();
	public Employee getEmployee(long id);
	public Employee updateEmployee(Employee e,long id);
	public void deleteEmployee(long id);
}
