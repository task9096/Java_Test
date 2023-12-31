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
@Table(name = "T_PURCHASE_ORDER_HISTORY")
public class PurchaseOrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PURCHASE_ORDER_HISTORY_ID")
    private Long id;

    @Column(name = "PURCHASE_ORDER_ID")
    private Long purchaseOrderId;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "ACTIVITY_DATE")
    private LocalDate activityDate;

    @Column(name = "ACTIVITY")
    private String activity;

    @Column(name = "TICKET_ID")
    private Long ticketId;

}
