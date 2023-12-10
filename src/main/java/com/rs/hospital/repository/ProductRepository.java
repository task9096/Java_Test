package com.rs.hospital.repository;

import com.rs.hospital.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product, Long> {
    @Query(value = "SELECT c FROM Product c WHERE c.productName = ?1")
    public Product existsProductByProductName(String productName);

    @Query(value = "SELECT c FROM Product c WHERE c.categoryId = ?1")
    public List<Product> getAllProductByCategoryId(long categoryId);


}
