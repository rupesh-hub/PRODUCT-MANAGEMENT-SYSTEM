package com.rupesh.app.services;

import java.util.List;

import com.rupesh.app.entities.CategoryDAO;

import javassist.NotFoundException;

public interface CategoryService {

	public abstract CategoryDAO saveCategory(CategoryDAO categoryDAO);

	public abstract CategoryDAO getCategory(Long categoryId) throws NotFoundException;

	public abstract List<CategoryDAO> getAllCategories();

	public abstract void deleteCategory(Long categoryId);
}
