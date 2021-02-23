package com.rupesh.app.model;

import com.rupesh.app.entities.CategoryDAO;
import com.rupesh.app.entities.ProductDAO;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

	private ProductDAO product;
	private CategoryDAO category;
}
