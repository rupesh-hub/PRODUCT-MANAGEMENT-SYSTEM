package com.rupesh.app.services;

import java.util.List;

import com.rupesh.app.entities.ProductDAO;
import com.rupesh.app.model.ProductResponse;

public interface ProductService {
	public abstract ProductDAO saveProduct(ProductDAO product);

	public abstract ProductResponse getProductById(Long productId) throws Exception;

	public abstract List<ProductDAO> getAllProducts();

	public abstract void deleteProduct(Long productId);
}
