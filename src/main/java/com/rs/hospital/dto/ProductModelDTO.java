package com.rs.hospital.dto;

import com.rs.hospital.model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductModelDTO {

    protected Long id;
    private Long productId;
    private String modelNumber;
    private String modelName;
    private BigDecimal price;
    private String imageUrl;
    private Long stock;
    private String productName;


    public ProductModelDTO(ProductModel productModel) {

        this.id = productModel.getId();
        this.productId = productModel.getProductId();
        this.modelNumber = productModel.getModelNumber();
        this.modelName  = productModel.getModelName();
        this.price = productModel.getPrice();
        this.imageUrl = productModel.getImageUrl();
        this.stock = productModel.getStock();
    }

}
