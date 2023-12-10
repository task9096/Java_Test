package com.rs.hospital.dto;

import com.rs.hospital.model.ProductModel;

import java.math.BigDecimal;

public class ProductModelDTO {

    protected Long id;
    private Long productId;
    private String modelNumber;
    private String modelName;
    private BigDecimal price;
    private String imageUrl;

    public ProductModelDTO() {
    }

    public ProductModelDTO(ProductModel productModel) {

        this.id = productModel.getId();
        this.productId = productModel.getProductId();
        this.modelNumber = productModel.getModelNumber();
        this.modelName  = productModel.getModelName();
        this.price = productModel.getPrice();
        this.imageUrl = productModel.getImageUrl();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
