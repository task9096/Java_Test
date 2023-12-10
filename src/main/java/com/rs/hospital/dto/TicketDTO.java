package com.rs.hospital.dto;

import com.rs.hospital.model.Ticket;

public class TicketDTO {

    protected Long id;
    private String name;
    private String status;
    private String businessName;
    private String ticketType;
    private String comments;
    private String contract;
    private String ticketsSource;
    private String resolution;
    private String contactName;
    private String supportMode;
    private Long mobileNo;
    private String email;

    public TicketDTO() {
    }

    public TicketDTO(Ticket ticket) {

        this.id = ticket.getId();
        this.name = ticket.getName();
        this.status = ticket.getStatus();
        this.businessName  = ticket.getBusinessName();
        this.ticketType = ticket.getTicketType();
        this.comments = ticket.getComments();
        this.contract = ticket.getContract();
        this.ticketsSource = ticket.getTicketsSource();
        this.resolution = ticket.getResolution();
        this.contactName = ticket.getContactName();
        this.supportMode = ticket.getSupportMode();
        this.mobileNo = ticket.getMobileNo();
        this.email = ticket.getEmail();
    }

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
