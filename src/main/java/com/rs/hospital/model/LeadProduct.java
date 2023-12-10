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
@Table(name = "T_LEAD_PRODUCT_MODEL")
public class LeadProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LEAD_PRODUCT_ID")
    private Long id;

    @Column(name = "LEAD_ID")
    private Long leadId;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "QUANTITY")
    private Long quantity;

    @Column(name = "MODEL_ID")
    private Long modelId;

    @Column(name = "CREATED_BY")
    private Long createdBy;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Transient
    private String modelName;

}
