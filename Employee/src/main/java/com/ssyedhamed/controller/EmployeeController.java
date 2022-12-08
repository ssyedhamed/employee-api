package com.ssyedhamed.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.ssyedhamed.entities.Employee;
import com.ssyedhamed.exceptions.ResourceNotFoundException;
import com.ssyedhamed.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/employees")
	public ResponseEntity< Employee>  saveEmployee(@RequestBody Employee e ) {
		this.empService.saveEmployee(e);
//		HttpHeaders headers=new HttpHeaders();
//		headers.add("emp", "something here");
		return new ResponseEntity<>(e,HttpStatus.CREATED);
	}
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return this.empService.getEmployees();
	}
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable String id) throws ResourceNotFoundException, NumberFormatException{
		
		return this.empService.getEmployee(Long.parseLong(id));
	}
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee e,@PathVariable String id) {
		return this.empService.updateEmployee(e, Long.parseLong(id));
	}
	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable String id) throws ResourceNotFoundException{
		this.empService.deleteEmployee(Long.parseLong(id));
		Map<String,Boolean> response=new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
