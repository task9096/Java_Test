package com.rs.hospital.dto;

import com.rs.hospital.model.Product;

public class ProductDTO {

    protected Long id;
    private Long categoryId;
    private String productName;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {

        this.id = product.getId();
        this.categoryId = product.getCategoryId();
        this.productName = product.getProductName();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
