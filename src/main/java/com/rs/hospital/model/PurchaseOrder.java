package com.rs.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_PURCHASE_ORDER")
public class PurchaseOrder{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PURCHASE_ORDER_ID")
    private Long id;

    @Column(name = "LEAD_ID")
    private Long leadId;

    @Column(name = "SALES_ORDER_ID")
    private Long salesOrderId;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "UPDATED_BY_USER_ID")
    private Long updatedUserId;

    @Column(name = "TOTAL_AMOUNT")
    private BigDecimal salesPrices;

    @Column(name = "FINAL_PRICE")
    private BigDecimal finalPrice;

    @Column(name = "DISCOUNT")
    private BigDecimal discount;

    @Column(name = "GST")
    private BigDecimal gst;

    @Column(name = "PONumber")
    private String poNumber;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "CREATED_DATE")
    private LocalDate createdDate;

    @Column(name = "STATUS_DATE")
    private LocalDateTime statusDate;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CLIENT_STATUS_DATE")
    private LocalDateTime clientStatusDate;

    @Column(name = "CLIENT_STATUS")
    private String clientStatus;

}

