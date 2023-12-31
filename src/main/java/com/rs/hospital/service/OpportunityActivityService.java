package com.rs.hospital.service;

import com.rs.hospital.dto.OpportunityActivityDTO;

import java.util.List;
import java.util.Map;

public interface OpportunityActivityService {
    public OpportunityActivityDTO save(OpportunityActivityDTO opportunityActivity);
    public OpportunityActivityDTO update(OpportunityActivityDTO opportunityActivity, long bid) throws Exception;
    public OpportunityActivityDTO getById(long bid) throws Exception;
    public List<OpportunityActivityDTO> getAll();
    public Map<String, Boolean> delete(long bid) throws Exception;
    public boolean isExists(OpportunityActivityDTO opportunityActivityDto);

    public String findCustomerNameById(long bid)  throws Exception;

}
