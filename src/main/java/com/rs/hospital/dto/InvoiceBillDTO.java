package com.rs.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class InvoiceBillDTO {

    //java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, java.lang.String, long, java.lang.String, java.lang.String,
    /*from customer*/
    private String customerName;
    private String email;
    private String address;
    private Long mobileNo;
    private String deliveryAddress;
    private String title;
    private Long pinCode;
    private String state;
    private String city;

    /*from LeadProduct*/
    private Long quantity;

    // java.lang.String,
    /*from category*/
    private String categoryName;

    // java.lang.String,
    /*from product*/
    private String productName;

    // java.lang.String, java.lang.String, java.math.BigDecimal, java.lang.String,
    /*from productModel*/
    private String modelNumber;
    private String modelName;
    private BigDecimal modelPrice;
    private String imageUrl;


    // long, java.math.BigDecimal,
    /*from SalesOrder*/
    private Long totalAmount;

    // java.math.BigDecimal, java.math.BigDecimal, java.math.BigDecimal, java.lang.String,
    /*from PurchaseOrder*/
    private BigDecimal salesPrices;
    private BigDecimal finalPrice;
    private BigDecimal discount;
    private BigDecimal gst;
    private String poNumber;

    // java.math.BigDecimal, java.time.LocalDateTime, java.lang.String
    /*from Invoice*/
    private BigDecimal totalDueAmount;
    private LocalDateTime invoiceDate;
    private String invoiceNumber;

    /*from LeadUpfrontInvoice*/
    private List<LeadUpfrontInvoiceDTO> listLeadUpfrontInvoiceDTO = new ArrayList<>();

    public InvoiceBillDTO(String customerName, String email, String address, Long mobileNo, String deliveryAddress, String title, Long pinCode, String state, String city, Long quantity, String categoryName, String productName, String modelNumber, String modelName, BigDecimal modelPrice, String imageUrl, Long totalAmount, BigDecimal salesPrices, BigDecimal finalPrice, BigDecimal discount, BigDecimal gst, String poNumber, BigDecimal totalDueAmount, LocalDateTime invoiceDate, String invoiceNumber) {
        this.customerName = customerName;
        this.email = email;
        this.address = address;
        this.mobileNo = mobileNo;
        this.deliveryAddress = deliveryAddress;
        this.title = title;
        this.pinCode = pinCode;
        this.state = state;
        this.city = city;
        this.quantity = quantity;
        this.categoryName = categoryName;
        this.productName = productName;
        this.modelNumber = modelNumber;
        this.modelName = modelName;
        this.modelPrice = modelPrice;
        this.imageUrl = imageUrl;
        this.totalAmount = totalAmount;
        this.salesPrices = salesPrices;
        this.finalPrice = finalPrice;
        this.discount = discount;
        this.gst = gst;
        this.poNumber = poNumber;
        this.totalDueAmount = totalDueAmount;
        this.invoiceDate = invoiceDate;
        this.invoiceNumber = invoiceNumber;
    }
}
