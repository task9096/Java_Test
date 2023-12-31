package com.rs.hospital.service;

import com.rs.hospital.dto.OpportunityDTO;

import java.util.List;
import java.util.Map;

public interface OpportunityService {
    public OpportunityDTO save(OpportunityDTO opportunity);
    public OpportunityDTO update(OpportunityDTO opportunity, long bid) throws Exception;
    public OpportunityDTO getById(long bid) throws Exception;
    public List<OpportunityDTO> getAll();
    public Map<String, Boolean> delete(long bid) throws Exception;
    public boolean isExists(OpportunityDTO opportunityDto);

}
