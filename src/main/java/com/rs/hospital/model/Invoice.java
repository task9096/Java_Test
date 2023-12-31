package com.rs.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_INVOICE")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVOICE_ID")
    private Long id;

    @Column(name = "TOTAL_PAID_AMOUNT")
    private BigDecimal totalPaidAmount;

    @Column(name = "TOTAL_DUE_AMOUNT")
    private BigDecimal totalDueAmount;

    @Column(name = "INVOICE_DATE")
    private LocalDateTime invoiceDate;

    @Column(name = "PURCHASE_ORDER_ID")
    private Long purchaseOrderId;

    @Column(name = "INVOICE_NUMBER")
    private String invoiceNumber;

}
