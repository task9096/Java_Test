package com.rs.hospital.model;





import javax.persistence.*;


@Entity
@Table(name = "T_BUSINESS")
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BUSINESS_ID")
    private Long id;

    @Column(name="CUST_ID")
    private Long custId;

    @Lob
    @Column(name = "COMMENT")
    private String comments;

    @Column(name = "PHONE")
    private Long mobileNo;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "BUSINESS_NAME")
    private String businessName;

    @Column(name = "ACCOUNT_RELATIONSHIP")
    private String accountRelationship;

    @Column(name = "INDUSTRY")
    private String industry;

    @Column(name = "MEMBER_OF")
    private String memberOf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getAccountRelationship() {
        return accountRelationship;
    }

    public void setAccountRelationship(String accountRelationship) {
        this.accountRelationship = accountRelationship;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(String memberOf) {
        this.memberOf = memberOf;
    }
}

