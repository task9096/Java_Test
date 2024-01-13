package com.rs.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OpportunityBean {

    protected Long id;
    protected Long leadId;
    private String opportunityName;
    private String accountName;
    protected Long productCategory;
    protected Long quantity;
    private BigDecimal expectedAmount;
    private LocalDate expectedCloseDate;
    private String salesStage;
    private LocalDate followupDate;
    private String extQuotationUrl;
    private String comments;
    private String leadSource;
    private String customerName;
}
