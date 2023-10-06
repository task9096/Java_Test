package com.rs.hospital.model;

import javax.persistence.*;

@Entity
@Table(name = "T_CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CUSTOMER_ID")
    private Long id;

    @Column(name = "NAME")
    private String fullName;

    @Column(name = "EMAIL")
    private String email;

    @Lob
    @Column(name = "address")
    private String address;

    @Column(name = "PHONENO")
    private Long mobileNo;

    @Lob
    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "title")
    private String title;

    @Column(name="pincode")
    private Long pincode;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long modileNo) {
        this.mobileNo = modileNo;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
