package com.rs.hospital.dto;

import com.rs.hospital.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {

    protected Long id;
    private Long categoryId;
    private String productName;
    private String categoryName;

    public ProductDTO(Product product) {

        this.id = product.getId();
        this.categoryId = product.getCategoryId();
        this.productName = product.getProductName();

    }
}
