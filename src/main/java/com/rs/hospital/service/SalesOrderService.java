package com.rs.hospital.service;

import com.rs.hospital.dto.SalesOrderDTO;
import com.rs.hospital.model.SalesOrder;

import java.util.List;

public interface SalesOrderService {
    public SalesOrderDTO getSalesOrderByLeadId(Long leadId);
    public String addSalesOrderByLeadId(Long leadId, Long userId);
    public List<SalesOrder> getAll();
}
