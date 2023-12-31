package com.rs.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DashBoardDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    @Column(name = "TOTALCUSTOMER")
    private Long totalCustomer;

    @Column(name = "LEADCOUNT")
    private Long leadCount;

    @Column(name = "OPENLEADCOUNT")
    private Long openLeadCount;

    @Column(name = "PORDER")
    private Long pOrder;
}
