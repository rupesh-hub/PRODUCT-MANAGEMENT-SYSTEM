package com.rupesh.app.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rupesh.app.model.Employee;
import com.rupesh.app.model.EmployeePage;
import com.rupesh.app.model.EmployeeSearchCriteria;
import com.rupesh.app.services.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<Page<Employee>> getEmployees(EmployeePage employeePage,
			EmployeeSearchCriteria searchCriteria) {
		return new ResponseEntity<>(employeeService.getEmployees(employeePage, searchCriteria), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
	}
	
}