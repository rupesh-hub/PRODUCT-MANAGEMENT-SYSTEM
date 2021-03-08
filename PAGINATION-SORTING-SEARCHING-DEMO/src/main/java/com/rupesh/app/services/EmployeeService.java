package com.rupesh.app.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.rupesh.app.model.Employee;
import com.rupesh.app.model.EmployeePage;
import com.rupesh.app.model.EmployeeSearchCriteria;
import com.rupesh.app.repository.EmployeeCriteriaRepository;
import com.rupesh.app.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final EmployeeCriteriaRepository employeeCriteriaRepository;

	public Page<Employee> getEmployees(EmployeePage employeePage, EmployeeSearchCriteria employeeSearchCriteria) {
		return employeeCriteriaRepository.findAllWithFilters(employeePage, employeeSearchCriteria);
	}

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
