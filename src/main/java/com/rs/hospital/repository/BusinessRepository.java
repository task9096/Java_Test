package com.rs.hospital.repository;

import com.rs.hospital.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusinessRepository extends JpaRepository<Business, Long> {
    @Query("SELECT c FROM Business c WHERE c.email = ?1")
    public Business findByEmail(String email);

    @Query("SELECT c FROM Business c WHERE c.email = ?1 and c.businessName = ?2")
    public List<Business> findByEmailAndName(String email, String businessName);

    @Query(value = "SELECT c FROM Business c WHERE c.email = ?1")
    public Business existsBusinessByEmail(String email);
}
