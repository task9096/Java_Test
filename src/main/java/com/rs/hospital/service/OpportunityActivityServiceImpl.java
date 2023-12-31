package com.rs.hospital.service;

import com.rs.hospital.dto.OpportunityActivityDTO;
import com.rs.hospital.model.*;
import com.rs.hospital.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;



@Service
@Transactional
public class OpportunityActivityServiceImpl implements OpportunityActivityService {

    @Autowired
    private OpportunityActivityRepository repo;

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private CustomerLeadRepository customerLeadRepository;

    @Autowired
    private CustomerRepository customerRepository;

    /**
     *
     * @param opportunityActivityDTO
     * @return
     *
     * Steps
     * 1	Convert DTO to model
     * 2	make all opertions = > CRUD
     * 3	convert model to dto
     */
    /*
     * Convert OpportunityActivity DTO class to OpportunityActivity Model Class
     */
    private OpportunityActivity convertDTOtoModel(OpportunityActivityDTO opportunityActivityDTO) {

        OpportunityActivity opportunityActivity = new OpportunityActivity();

        opportunityActivity.setId(opportunityActivityDTO.getId());
        opportunityActivity.setActivityType(opportunityActivityDTO.getActivityType());
        opportunityActivity.setComment(opportunityActivityDTO.getComment());
        opportunityActivity.setCustomerName(opportunityActivityDTO.getCustomerName());
        opportunityActivity.setDuration(opportunityActivityDTO.getDuration());
        opportunityActivity.setEndDate(opportunityActivityDTO.getEndDate());
        opportunityActivity.setExecutedTime(opportunityActivityDTO.getExecutedTime());
        opportunityActivity.setFollowupBy(opportunityActivityDTO.getFollowupBy());
        opportunityActivity.setOpportunityId(opportunityActivityDTO.getOpportunityId());
        opportunityActivity.setStartDate(opportunityActivityDTO.getStartDate());
        opportunityActivity.setStatus(opportunityActivityDTO.getStatus());

        return opportunityActivity;
    }

    /*
     * Convert Model To DTO
     */
    private OpportunityActivityDTO convertModelToDTO(OpportunityActivity opportunityActivity) {
        return new OpportunityActivityDTO(opportunityActivity);
    }

    @Override
    public OpportunityActivityDTO save(OpportunityActivityDTO OpportunityActivityDTO) {
        OpportunityActivity opportunityActivity = convertDTOtoModel(OpportunityActivityDTO); // convert dto to model for database interaction

        return convertModelToDTO(repo.save(opportunityActivity)); // return DTO
    }

    @Override
    public OpportunityActivityDTO update(OpportunityActivityDTO opportunityActivityDTO, long bid) throws Exception {

        OpportunityActivityDTO copyOpportunityActivity = getById(bid);

        copyOpportunityActivity.setId(opportunityActivityDTO.getId());
        copyOpportunityActivity.setActivityType(opportunityActivityDTO.getActivityType());
        copyOpportunityActivity.setComment(opportunityActivityDTO.getComment());
        copyOpportunityActivity.setCustomerName(opportunityActivityDTO.getCustomerName());
        copyOpportunityActivity.setDuration(opportunityActivityDTO.getDuration());
        copyOpportunityActivity.setEndDate(opportunityActivityDTO.getEndDate());
        copyOpportunityActivity.setExecutedTime(opportunityActivityDTO.getExecutedTime());
        copyOpportunityActivity.setFollowupBy(opportunityActivityDTO.getFollowupBy());
        copyOpportunityActivity.setOpportunityId(opportunityActivityDTO.getOpportunityId());
        copyOpportunityActivity.setStartDate(opportunityActivityDTO.getStartDate());
        copyOpportunityActivity.setStatus(opportunityActivityDTO.getStatus());


        // step 1 
        OpportunityActivity OpportunityActivity = convertDTOtoModel(copyOpportunityActivity);

        //step 2

        // step 3
        return convertModelToDTO(repo.save(OpportunityActivity));
    }

    @Override
    public OpportunityActivityDTO getById(long bid) throws Exception {
        OpportunityActivity opportunityActivity = repo.findById(bid)
                .orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + bid));
        return convertModelToDTO(opportunityActivity);
    }

    @Override
    public String findCustomerNameById(long opportunityId) throws Exception {
        Opportunity opportunity = opportunityRepository.getOne(opportunityId);
        CustomerLead customerLead = customerLeadRepository.getOne(opportunity.getLeadId());
        Customer customer = customerRepository.getOne(customerLead.getCustomerId());
        return customer.getFullName();
    }


    @Override
    public List<OpportunityActivityDTO> getAll() {
        List<OpportunityActivity> opportunityActivityList = repo.findAll();
        List<OpportunityActivityDTO> opportunityActivityDTOList = new ArrayList<>();

        for(OpportunityActivity OpportunityActivity : opportunityActivityList) {
            opportunityActivityDTOList.add(convertModelToDTO(OpportunityActivity));
        }

        return opportunityActivityDTOList;
    }

    @Override
    public Map<String, Boolean> delete(long bid) throws Exception {
        OpportunityActivity opportunityActivity = convertDTOtoModel(getById(bid));
        repo.delete(opportunityActivity);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Delete", Boolean.TRUE);

        return response;

    }

    @Override
    public boolean isExists(OpportunityActivityDTO opportunityActivityDTO) {
        OpportunityActivity emp = repo.existsOppActByOppId(opportunityActivityDTO.getOpportunityId());
        if(emp != null) {
            return true;
        }else {
            return false;
        }
    }


}
