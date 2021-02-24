package com.rupesh.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rupesh.app.entities.CategoryDAO;

@RepositoryRestResource(collectionResourceRel = "category",path = "product-category")
public interface CategoryRepository extends JpaRepository<CategoryDAO, Long> {

}
