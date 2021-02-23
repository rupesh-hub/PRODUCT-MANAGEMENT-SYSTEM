package com.rupesh.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rupesh.app.entities.CategoryDAO;
import com.rupesh.app.repository.CategoryRepository;
import com.rupesh.app.services.CategoryService;

import javassist.NotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public CategoryDAO saveCategory(CategoryDAO category) {
		return this.categoryRepository.save(category);
	}

	@Override
	public CategoryDAO getCategory(Long categoryId) throws NotFoundException {
		Optional<CategoryDAO> findById = this.categoryRepository.findById(categoryId);
		if (findById.isPresent()) {
			return findById.get();
		}
		throw new NotFoundException("product category with provided category id = " + categoryId + " not found.");
	}

	@Override
	public List<CategoryDAO> getAllCategories() {
		return this.categoryRepository.findAll();
	}

	@Override
	public void deleteCategory(Long categoryId) {
		this.categoryRepository.deleteById(categoryId);
	}
}
