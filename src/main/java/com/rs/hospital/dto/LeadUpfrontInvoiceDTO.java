package com.rs.hospital.dto;

import com.rs.hospital.model.LeadUpfrontInvoice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeadUpfrontInvoiceDTO {

    private Long id;
    private Long invoiceId;
    private BigDecimal dueAmount;
    private LocalDateTime invoiceDate;
    private String upFrontInvoiceNumber;
    private BigDecimal paidAmount;
    private LocalDateTime paidDate;

    public LeadUpfrontInvoiceDTO(LeadUpfrontInvoice leadUpfrontInvoice) {
        this.id = leadUpfrontInvoice.getId();
        this.invoiceId = leadUpfrontInvoice.getInvoiceId();
        this.dueAmount = leadUpfrontInvoice.getDueAmount();
        this.invoiceDate = leadUpfrontInvoice.getInvoiceDate();
        this.upFrontInvoiceNumber = leadUpfrontInvoice.getUpFrontInvoiceNumber();
        this.paidAmount = leadUpfrontInvoice.getPaidAmount();
        this.paidDate = leadUpfrontInvoice.getPaidDate();
    }

}
