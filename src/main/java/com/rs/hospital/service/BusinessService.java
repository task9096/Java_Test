package com.rs.hospital.service;

import com.rs.hospital.dto.BusinessDTO;

import java.util.List;
import java.util.Map;

public interface BusinessService {
    public BusinessDTO save(BusinessDTO businessDto);
    public BusinessDTO update(BusinessDTO businessDto, long bid) throws Exception;
    public BusinessDTO getById(long bid) throws Exception;
    public List<BusinessDTO> getAll();
    public Map<String, Boolean> delete(long bid) throws Exception;
    public boolean isExists(BusinessDTO businessDto);
}
