package com.rs.hospital.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_CONTACT")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CONTACT_ID")
    protected Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Lob
    @Column(name = "ACCOUNT_NAME")
    private String accountName;

    @Column(name = "PHONE")
    private Long mobileNo;

    @Column(name = "ACCOUNT_RELATIONSHIP")
    private String accountRelationship;

    @Column(name = "DESIGNATION")
    private String designation;

    @Column(name="DEPARTMENT")
    private String department;

    @Column(name = "FOLLOWUP_TYPE")
    private String followupType;

    @Lob
    @Column(name = "SUMMARY")
    private String summary;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAccountRelationship() {
        return accountRelationship;
    }

    public void setAccountRelationship(String accountRelationship) {
        this.accountRelationship = accountRelationship;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFollowupType() {
        return followupType;
    }

    public void setFollowupType(String followupType) {
        this.followupType = followupType;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }



    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", accountName='" + accountName + '\'' +
                ", mobileNo=" + mobileNo +
                ", accountRelationship='" + accountRelationship + '\'' +
                ", designation='" + designation + '\'' +
                ", department=" + department +
                ", followupType='" + followupType + '\'' +
                ", summary='" + summary + '\'' +
                ", createDate=" + createDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}




