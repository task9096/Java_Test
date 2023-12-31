package com.rs.hospital.service;

import com.rs.hospital.dto.OpportunityDTO;
import com.rs.hospital.model.Opportunity;
import com.rs.hospital.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;



@Service
@Transactional
public class OpportunityServiceImpl implements OpportunityService {

    @Autowired
    private OpportunityRepository repo;

    /**
     *
     * @param opportunityDTO
     * @return
     *
     * Steps
     * 1	Convert DTO to model
     * 2	make all opertions = > CRUD
     * 3	convert model to dto
     */
    /*
     * Convert Opportunity DTO class to Opportunity Model Class
     */
    private Opportunity convertDTOtoModel(OpportunityDTO opportunityDTO) {

        Opportunity opportunity = new Opportunity();

        opportunity.setId(opportunityDTO.getId());
        opportunity.setAccountName(opportunityDTO.getAccountName());
        opportunity.setComments(opportunityDTO.getComments());
        opportunity.setExpectedAmount(opportunityDTO.getExpectedAmount());
        opportunity.setExpectedCloseDate(opportunityDTO.getExpectedCloseDate());
        opportunity.setExtQuotationUrl(opportunityDTO.getExtQuotationUrl());
        opportunity.setFollowupDate(opportunityDTO.getFollowupDate());
        opportunity.setLeadId(opportunityDTO.getLeadId());
        opportunity.setLeadSource(opportunityDTO.getLeadSource());
        opportunity.setOpportunityName(opportunityDTO.getOpportunityName());
        opportunity.setQuantity(opportunityDTO.getQuantity());
        opportunity.setSalesStage(opportunityDTO.getSalesStage());
        opportunity.setProductCategory(opportunityDTO.getProductCategory());

        return opportunity;
    }

    /*
     * Convert Model To DTO
     */
    private OpportunityDTO convertModelToDTO(Opportunity opportunity) {
        return new OpportunityDTO(opportunity);
    }

    @Override
    public OpportunityDTO save(OpportunityDTO OpportunityDTO) {
        Opportunity opportunity = convertDTOtoModel(OpportunityDTO); // convert dto to model for database interaction

        return convertModelToDTO(repo.save(opportunity)); // return DTO
    }

    @Override
    public OpportunityDTO update(OpportunityDTO opportunityDTO, long bid) throws Exception {

        OpportunityDTO copyOpportunity = getById(bid);

        copyOpportunity.setId(opportunityDTO.getId());
        copyOpportunity.setAccountName(opportunityDTO.getAccountName());
        copyOpportunity.setComments(opportunityDTO.getComments());
        copyOpportunity.setExpectedAmount(opportunityDTO.getExpectedAmount());
        copyOpportunity.setExpectedCloseDate(opportunityDTO.getExpectedCloseDate());
        copyOpportunity.setExtQuotationUrl(opportunityDTO.getExtQuotationUrl());
        copyOpportunity.setFollowupDate(opportunityDTO.getFollowupDate());
        copyOpportunity.setLeadId(opportunityDTO.getLeadId());
        copyOpportunity.setLeadSource(opportunityDTO.getLeadSource());
        copyOpportunity.setOpportunityName(opportunityDTO.getOpportunityName());
        copyOpportunity.setQuantity(opportunityDTO.getQuantity());
        copyOpportunity.setSalesStage(opportunityDTO.getSalesStage());
        copyOpportunity.setProductCategory(opportunityDTO.getProductCategory());

        // step 1 
        Opportunity Opportunity = convertDTOtoModel(copyOpportunity);

        //step 2

        // step 3
        return convertModelToDTO(repo.save(Opportunity));
    }

    @Override
    public OpportunityDTO getById(long bid) throws Exception {
        Opportunity opportunity = repo.findById(bid)
                .orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + bid));
        return convertModelToDTO(opportunity);
    }

    @Override
    public List<OpportunityDTO> getAll() {
        List<Opportunity> opportunityList = repo.findAll();
        List<OpportunityDTO> opportunityDTOList = new ArrayList<>();

        for(Opportunity Opportunity : opportunityList) {
            opportunityDTOList.add(convertModelToDTO(Opportunity));
        }

        return opportunityDTOList;
    }

    @Override
    public Map<String, Boolean> delete(long bid) throws Exception {
        Opportunity opportunity = convertDTOtoModel(getById(bid));
        repo.delete(opportunity);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Delete", Boolean.TRUE);

        return response;

    }

    @Override
    public boolean isExists(OpportunityDTO empDto) {
        Opportunity emp = repo.existsOpportunityByLead(empDto.getLeadId());
        if(emp != null) {
            return true;
        }else {
            return false;
        }
    }


}
