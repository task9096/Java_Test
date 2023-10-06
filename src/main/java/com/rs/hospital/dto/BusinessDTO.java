package com.rs.hospital.dto;

import com.rs.hospital.model.Business;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class BusinessDTO {
    private Long id;
    private Long custId;
    private String comments;
    private Long mobileNo;
    private String email;
    private String businessName;
    private String accountRelationship;
    private String industry;
    private String memberOf;

    public BusinessDTO() {
    }

    public BusinessDTO(Business business) {

        this.id = business.getId();
        this.email = business.getEmail();
        this.mobileNo = business.getMobileNo();
        this.comments = business.getComments();
        this.businessName = business.getBusinessName();
        this.accountRelationship = business.getAccountRelationship();
        this.memberOf = business.getMemberOf();
        this.industry = business.getIndustry();
        this.custId = business.getCustId();
    }
}

