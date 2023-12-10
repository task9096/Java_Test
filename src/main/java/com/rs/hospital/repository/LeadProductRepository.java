package com.rs.hospital.repository;

import com.rs.hospital.model.LeadProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LeadProductRepository extends JpaRepository<LeadProduct, Long> {
    @Query("SELECT c FROM LeadProduct c WHERE c.leadId = ?1")
    public LeadProduct findByLeadId(Long leadId);

/*    @Query("SELECT c FROM CustomerLead c WHERE c.email = ?1 and c.fullName = ?2")
    public List<CustomerLead> findByEmailAndFullName(String email, String fullName);*/

    /*@Query(value = "SELECT c FROM LeadProduct c WHERE c.customerId = ?1")
    public LeadProduct existsCustomerLeadByCustomerId(Long customerId);*/
}