package com.rs.hospital.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_PRODUCT_MODEL")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MODEL_ID")
    private Long id;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "MODEL_NUMBER")
    private String modelNumber;

    @Column(name = "MODEL_NAME")
    private String modelName;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "STOCK")
    private Long stock;

}
