package com.rs.hospital.dto;

import com.rs.hospital.model.CustomerLead;
import com.rs.hospital.model.LeadProduct;

import java.math.BigDecimal;

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

    public CustomerLeadDTO() {
    }

    public CustomerLeadDTO(Long id, Long categoryId, Long customerId, Long dealerId, String note, String remark, String source, Integer statusId, String statusName,
                           Long productId,Long quantity,Long modelId,BigDecimal price,BigDecimal amount) {
        this.id = id;
        this.categoryId = categoryId;
        this.customerId = customerId;
        this.dealerId = dealerId;
        this.note = note;
        this.remark = remark;
        this.source = source;
        this.statusId = statusId;
        this.statusName = statusName;
        this.productId = productId;
        this.quantity = quantity;
        this.modelId = modelId;
        this.price = price;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getDealerId() {
        return dealerId;
    }

    public void setDealerId(Long dealerId) {
        this.dealerId = dealerId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Long getProductId() { return productId; }

    public void setProductId(Long productId) { this.productId = productId;}

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
