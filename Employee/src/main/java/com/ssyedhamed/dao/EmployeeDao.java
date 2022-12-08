package com.ssyedhamed.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssyedhamed.entities.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
