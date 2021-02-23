package com.rupesh.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rupesh.app.entities.CategoryDAO;
import com.rupesh.app.services.CategoryService;

@RestController
@RequestMapping(path = "/api/v1/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping(path = "/save", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<CategoryDAO> saveCategory(@RequestBody CategoryDAO category) {
		CategoryDAO savedCategory = this.categoryService.saveCategory(category);
		return ResponseEntity.ok().body(savedCategory);
	}

	@GetMapping(path = "/get-all")
	public ResponseEntity<List<CategoryDAO>> getAllCategories() {
		return ResponseEntity.ok().body(this.categoryService.getAllCategories());
	}

	@GetMapping(path = "/get/{id}")
	public ResponseEntity<CategoryDAO> getCategory(@PathVariable("id") Long categoryId) throws Exception {
		return ResponseEntity.ok().body(this.categoryService.getCategory(categoryId));
	}
}
