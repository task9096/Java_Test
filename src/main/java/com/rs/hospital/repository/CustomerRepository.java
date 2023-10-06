package com.rs.hospital.repository;

import com.rs.hospital.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    public Customer findByEmail(String email);

    @Query("SELECT c FROM Customer c WHERE c.email = ?1 and c.fullName = ?2")
    public List<Customer> findByEmailAndFullName(String email, String fullName);

    @Query(value = "SELECT c FROM Customer c WHERE c.email = ?1")
    public Customer existsCustomerByEmail(String email);
}