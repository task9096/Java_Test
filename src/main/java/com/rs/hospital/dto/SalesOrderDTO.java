package com.rs.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesOrderDTO {
    private Long id;

    private Long leadId;

    private Long userId;

    private String userName;

    private BigDecimal totalAmount;

    private LocalDate createdDate;

    private Long categoryId;

    private String categoryName;

    private Long customerId;

    private String customerName;

    private Long dealerId;

    private String dealerName;

    private String note;

    private String remark;

    private String source;

    private Integer statusId;

    private String statusName;

    private Long productId;

    private String productName;

    private Long quantity;

    private Long modelId;

    private String modelName;

    private Long createdBy;

    private BigDecimal price;

    private BigDecimal amount;

    private String modelNumber;

    private String imageUrl;

}
