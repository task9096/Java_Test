package com.rs.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "T_OPPORTUNITY")
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="OPPORTUNITY_ID")
    protected Long id;

    @Column(name="LEAD_ID")
    protected Long leadId;

    @Column(name = "OPPORTUNITY_NAME")
    private String opportunityName;

    @Column(name = "ACCOUNT_NAME")
    private String accountName;

    @Column(name="PRODUCT_CATEGORY")
    protected Long productCategory;

    @Column(name="QUANTITY")
    protected Long quantity;

    @Column(name = "expected_amount")
    private BigDecimal expectedAmount;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "EXPECTED_CLOSE_DATE")
    private LocalDate expectedCloseDate;

    @Column(name = "sales_stage")
    private String salesStage;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "FOLLOWUP_DATE")
    private LocalDate followupDate;

    @Lob
    @Column(name = "EXT_QUOTATION_URL")
    private String extQuotationUrl;

    @Lob
    @Column(name = "COMMENTS")
    private String comments;


    @Column(name="LEAD_SOURCE")
    private String leadSource;

}
