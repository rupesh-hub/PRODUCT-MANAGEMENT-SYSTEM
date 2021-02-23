package com.rupesh.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rupesh.app.entities.ProductDAO;

public interface ProductRepository extends JpaRepository<ProductDAO, Long> {

}
