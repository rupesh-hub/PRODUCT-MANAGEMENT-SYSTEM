package com.rupesh.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rupesh.app.entities.CategoryDAO;

public interface CategoryRepository extends JpaRepository<CategoryDAO, Long> {

}
