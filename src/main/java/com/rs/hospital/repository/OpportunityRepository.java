package com.rs.hospital.repository;

import com.rs.hospital.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

    @Query(value = "SELECT c FROM Opportunity c WHERE c.leadId = ?1")
    public Opportunity existsOpportunityByLead(Long leadId);
}
