package com.rupesh.app.model;

import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePage {

	private int pageNumber = 0;
	private int pageSize = 10;
	private Sort.Direction sortDirection = Sort.Direction.ASC;
	private String sortBy = "lastName";

}
