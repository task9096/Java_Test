package com.rs.hospital.repository;

import com.rs.hospital.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductModelRepository  extends JpaRepository<ProductModel, Long> {

    @Query(value = "SELECT c FROM ProductModel c WHERE c.modelNumber = ?1")
    public ProductModel existsProductModelByModelNumber(String modelNumber);

    @Query(value = "SELECT c FROM ProductModel c WHERE c.productId = ?1")
    public List<ProductModel> getProductModelByProductId(long productId);
}
