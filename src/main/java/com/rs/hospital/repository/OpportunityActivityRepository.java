package com.rs.hospital.repository;

import com.rs.hospital.model.Opportunity;
import com.rs.hospital.model.OpportunityActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OpportunityActivityRepository extends JpaRepository<OpportunityActivity, Long> {
    @Query(value = "SELECT c FROM OpportunityActivity c WHERE c.opportunityId = ?1")
    public OpportunityActivity existsOppActByOppId(Long leadId);


}
