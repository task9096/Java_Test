package com.rs.hospital.dto;



import com.rs.hospital.model.Dealer;

public class DealerDTO {

    private Long id;

    private String fullName;

    private String email;

    private String address;

    private Long mobileNo;

    private String deliveryAddress;

    private String title;

    private Long pinCode;

    private String state;

    private String city;

    public DealerDTO(Dealer dealer) {

        this.id = dealer.getId();
        this.fullName = dealer.getFullName();
        this.email = dealer.getEmail();
        this.address = dealer.getAddress();
        this.mobileNo = dealer.getMobileNo();
        this.deliveryAddress = dealer.getDeliveryAddress();
        this.title = dealer.getTitle();
        this.pinCode = dealer.getPincode();
        this.state = dealer.getState();
        this.city = dealer.getCity();
    }

    public DealerDTO() {
    }

    public DealerDTO(Long id, String fullName, String email, String address, Long mobileNo, String deliveryAddress, String title, Long pinCode, String state, String city) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.mobileNo = mobileNo;
        this.deliveryAddress = deliveryAddress;
        this.title = title;
        this.pinCode = pinCode;
        this.state = state;
        this.city = city;
    }

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

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
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

    public Long getPinCode() {
        return pinCode;
    }

    public void setPinCode(Long pinCode) {
        this.pinCode = pinCode;
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
