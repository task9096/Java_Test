package com.rs.hospital.model;

import javax.persistence.*;

@Entity
@Table(name = "T_Lead")
public class CustomerLead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LEAD_ID")
    private Long id;

    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "DEALER_ID")
    private Long dealerId;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "SOURCE")
    private String source;

    @Column(name = "STATUS_ID")
    private Integer statusId;

    @Column(name = "STATUS_NAME")
    private String statusName;

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
}
