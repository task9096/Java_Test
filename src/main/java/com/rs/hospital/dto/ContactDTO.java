package com.rs.hospital.dto;


import com.rs.hospital.model.Contact;

import java.time.LocalDateTime;

public class ContactDTO {
    protected Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String accountName;

    private Long mobileNo;

    private String accountRelationship;

    private String designation;

    private String department;

    private String followupType;

    private String summary;

    private LocalDateTime createDate;

    private LocalDateTime updatedDate;

    public ContactDTO() {
    }

    public ContactDTO(Contact contact) {
        this.id = contact.getId();
        this.firstName = contact.getFirstName();
        this.lastName = contact.getLastName();
        this.email = contact.getEmail();
        this.accountName = contact.getAccountName();
        this.mobileNo = contact.getMobileNo();
        this.accountRelationship = contact.getAccountRelationship();
        this.designation = contact.getDesignation();
        this.department = contact.getDepartment();
        this.followupType = contact.getFollowupType();
        this.summary = contact.getSummary();
        this.createDate = contact.getCreateDate();
        this.updatedDate = contact.getUpdatedDate();
    }

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
}
