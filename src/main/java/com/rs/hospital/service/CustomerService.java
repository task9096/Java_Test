package com.rs.hospital.service;

import com.rs.hospital.dto.CustomerDTO;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    public CustomerDTO save(CustomerDTO customer);
    public CustomerDTO update(CustomerDTO customer, long bid) throws Exception;
    public CustomerDTO getById(long bid) throws Exception;
    public List<CustomerDTO> getAll();
    public Map<String, Boolean> delete(long bid) throws Exception;
    public boolean isExists(CustomerDTO customerDto);
    public CustomerDTO profileByUserId(long userId);
}
