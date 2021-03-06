package com.rupesh.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rupesh.app.entities.ProductDAO;
import com.rupesh.app.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping(path = "/save", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ProductDAO> saveProduct(@RequestBody ProductDAO product) {

		ProductDAO savedProduct = this.productService.saveProduct(product);
		return ResponseEntity.ok().body(savedProduct);
	}

	@GetMapping(path = "/get/{id}")
	public ResponseEntity<ProductDAO> getProduct(@PathVariable("id") Long productId) throws Exception {
		return ResponseEntity.ok().body(this.productService.getProductById(productId));
	}
}
