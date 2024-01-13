package com.rs.hospital.dto;

import com.rs.hospital.model.PurchaseOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderDTO {

    private Long id;

    private Long leadId;

    private Long salesOrderId;

    private Long userId;

    private Long updatedUserId;

    private BigDecimal salesPrices;

    private BigDecimal finalPrice;

    private BigDecimal discount;

    private BigDecimal gst;

    private String poNumber;

    private LocalDate createdDate;

    private LocalDateTime statusDate;

    private String status;

    private LocalDateTime clientStatusDate;

    private String clientStatus;

    private String fullName;

    private Long quantity;

    public PurchaseOrderDTO(PurchaseOrder purchaseOrder) {

        this.id = purchaseOrder.getId();
        this.leadId = purchaseOrder.getLeadId();
        this.salesOrderId = purchaseOrder.getSalesOrderId();
        this.userId = purchaseOrder.getUserId();
        this.updatedUserId = purchaseOrder.getUpdatedUserId();
        this.salesPrices = purchaseOrder.getSalesPrices();
        this.finalPrice = purchaseOrder.getFinalPrice();
        this.discount = purchaseOrder.getDiscount();
        this.gst = purchaseOrder.getGst();
        this.poNumber = purchaseOrder.getPoNumber();
        this.createdDate = purchaseOrder.getCreatedDate();
        this.statusDate = purchaseOrder.getStatusDate();
        this.status = purchaseOrder.getStatus();
        this.clientStatusDate = purchaseOrder.getClientStatusDate();
        this.clientStatus = purchaseOrder.getClientStatus();
    }
}
