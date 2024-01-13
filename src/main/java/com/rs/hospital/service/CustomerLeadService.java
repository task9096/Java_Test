package com.rs.hospital.service;

import com.rs.hospital.dto.CustomerLeadDTO;

import java.util.List;
import java.util.Map;

public interface CustomerLeadService {
    public CustomerLeadDTO save(CustomerLeadDTO customerLead);
    public CustomerLeadDTO update(CustomerLeadDTO customerLead, long bid) throws Exception;
    public CustomerLeadDTO getById(long bid) throws Exception;
    public List<CustomerLeadDTO> getAll();
    public List<CustomerLeadDTO> listAllForSalesOrder();
    public List<CustomerLeadDTO> listAllForOpportunity();
    public Map<String, Boolean> delete(long bid) throws Exception;
    public boolean isExists(CustomerLeadDTO customerLeadDto);

}
