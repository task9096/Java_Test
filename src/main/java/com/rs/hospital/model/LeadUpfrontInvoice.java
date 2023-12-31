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
@Table(name = "T_Lead_Upfront_Invoice")
public class LeadUpfrontInvoice{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UPFRONT_INVOICE_ID")
    private Long id;

    @Column(name = "INVOICE_ID")
    private Long invoiceId;

    @Column(name = "DUE_AMOUNT")
    private BigDecimal dueAmount;

    @Column(name = "INVOICE_DATE")
    private LocalDateTime invoiceDate;

    @Column(name = "UpFRONT_INVOICE_NUMBER")
    private String upFrontInvoiceNumber;

    @Column(name = "PAID_AMOUNT")
    private BigDecimal paidAmount;

    @Column(name = "PAID_DATE")
    private LocalDateTime paidDate;

}
