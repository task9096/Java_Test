package com.rs.hospital.repository;

import com.rs.hospital.model.CustomerLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerLeadRepository extends JpaRepository<CustomerLead, Long> {
    @Query("SELECT c FROM CustomerLead c WHERE c.customerId = ?1")
    public CustomerLead findByEmail(Long customerId);

/*    @Query("SELECT c FROM CustomerLead c WHERE c.email = ?1 and c.fullName = ?2")
    public List<CustomerLead> findByEmailAndFullName(String email, String fullName);*/

    @Query(value = "SELECT c FROM CustomerLead c WHERE c.customerId = ?1")
    public CustomerLead existsCustomerLeadByCustomerId(Long customerId);
}
