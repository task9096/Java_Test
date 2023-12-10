package com.rs.hospital.model;


import javax.persistence.*;

@Entity
@Table(name = "T_TICKETS")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TICKETS_ID")
    protected Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "BUSINESS_NAME")
    private String businessName;

    @Column(name = "TICKET_TYPE")
    private String ticketType;

    @Lob
    @Column(name = "COMMENT")
    private String comments;

    @Column(name = "CONTRACT")
    private String contract;

    @Column(name = "TICKETS_SOURCE")
    private String ticketsSource;

    @Lob
    @Column(name = "RESOLUTION")
    private String resolution;

    @Column(name="CONTACT_NAME")
    private String contactName;

    @Column(name = "support_mode")
    private String supportMode;

    @Column(name = "PHONE")
    private Long mobileNo;

    @Column(name = "EMAIL")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getTicketsSource() {
        return ticketsSource;
    }

    public void setTicketsSource(String ticketsSource) {
        this.ticketsSource = ticketsSource;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getSupportMode() {
        return supportMode;
    }

    public void setSupportMode(String supportMode) {
        this.supportMode = supportMode;
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
}
