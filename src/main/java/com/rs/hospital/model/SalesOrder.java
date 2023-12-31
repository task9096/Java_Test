package com.rs.hospital.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_SALES_ORDER")
public class SalesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SALES_ORDER_ID")
    private Long id;

    @Column(name = "LEAD_ID")
    private Long leadId;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "TOTAL_AMOUNT")
    private Long totalAmount;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "CREATED_DATE")
    private LocalDate createdDate;

    @Column(name = "STATUS")
    private String status;


}

