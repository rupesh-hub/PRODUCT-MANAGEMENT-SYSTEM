package com.rupesh.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rupesh.app.entities.ProductDAO;

@RepositoryRestResource(collectionResourceRel = "product",path = "products")
public interface ProductRepository extends JpaRepository<ProductDAO, Long> {

}
