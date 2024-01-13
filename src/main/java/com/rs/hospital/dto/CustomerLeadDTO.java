package com.rs.hospital.dto;

import com.rs.hospital.model.CustomerLead;
import com.rs.hospital.model.LeadProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomerLeadDTO {

    private Long id;

    private Long categoryId;

    private Long customerId;

    private Long dealerId;

    private String note;

    private String remark;

    private String source;

    private Integer statusId;

    private String statusName;

    private Long productId;

    private Long quantity;

    private Long modelId;

    private BigDecimal price;

    private BigDecimal amount;

    private String categoryName;

    private String productName;

    private String modelName;

    private String customerName;

    public CustomerLeadDTO(CustomerLead customerLead, LeadProduct leadProduct) {

        this.id = customerLead.getId();
        this.categoryId = customerLead.getCategoryId();
        this.customerId = customerLead.getCustomerId();
        this.dealerId = customerLead.getDealerId();
        this.note = customerLead.getNote();
        this.remark = customerLead.getRemark();
        this.source = customerLead.getSource();
        this.statusId = customerLead.getStatusId();
        this.statusName = customerLead.getStatusName();
        this.productId= leadProduct.getProductId();
        this.quantity = leadProduct.getQuantity();
        this.modelId = leadProduct.getModelId();
        this.price = leadProduct.getPrice();
        this.amount = leadProduct.getAmount();
    }

}
