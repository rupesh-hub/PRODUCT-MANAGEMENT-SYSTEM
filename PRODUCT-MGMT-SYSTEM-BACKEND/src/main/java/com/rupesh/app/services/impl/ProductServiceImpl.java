package com.rupesh.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rupesh.app.entities.CategoryDAO;
import com.rupesh.app.entities.ProductDAO;
import com.rupesh.app.model.ProductResponse;
import com.rupesh.app.repository.ProductRepository;
import com.rupesh.app.services.CategoryService;
import com.rupesh.app.services.ProductService;

import javassist.NotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryService categoryService;

	@Override
	public ProductDAO saveProduct(ProductDAO product) {
		return this.productRepository.save(product);
	}

	@Override
	public ProductResponse getProductById(Long productId) throws Exception {
		Optional<ProductDAO> findById = this.productRepository.findById(productId);

		if (findById.isPresent()) {
			ProductDAO product = findById.get();
			CategoryDAO category = this.categoryService.getCategory(product.getCategoryId());
			ProductResponse response = new ProductResponse();
			response.setCategory(category);
			response.setProduct(product);
			return response;
		}
		throw new NotFoundException("product with provided product id = " + productId + " is not found");
	}

	@Override
	public List<ProductDAO> getAllProducts() {
		return this.productRepository.findAll();
	}

	@Override
	public void deleteProduct(Long productId) {
		this.productRepository.deleteById(productId);
	}

}
