package com.rs.hospital.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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


}
