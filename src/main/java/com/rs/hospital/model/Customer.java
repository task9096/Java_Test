package com.rs.hospital.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
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


}
