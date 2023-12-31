package com.rs.hospital.dto;



import com.rs.hospital.model.Dealer;
import com.rs.hospital.model.Invoice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDTO {
    private Long id;
    BigDecimal totalPaidAmount;
    private BigDecimal totalDueAmount;
    private LocalDateTime invoiceDate;
    private Long purchaseOrderId;
    private String invoiceNumber;

    public InvoiceDTO(Invoice invoice) {

        this.id = invoice.getId();
        this.totalPaidAmount = invoice.getTotalPaidAmount();
        this.totalDueAmount = invoice.getTotalDueAmount();
        this.invoiceDate = invoice.getInvoiceDate();
        this.purchaseOrderId = invoice.getPurchaseOrderId();
        this.invoiceNumber = invoice.getInvoiceNumber();

    }
}
