package com.rs.hospital.repository;

import com.rs.hospital.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
    @Query(value = "SELECT c FROM Category c WHERE c.categoryName = ?1")
    public Category existsCategoryByCategoryName(String email);
}
