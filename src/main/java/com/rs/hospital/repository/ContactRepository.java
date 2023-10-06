package com.rs.hospital.repository;

import com.rs.hospital.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query("SELECT c FROM Contact c WHERE c.email = ?1")
    public Contact findByEmail(String email);

    @Query("SELECT c FROM Contact c WHERE c.email = ?1 and c.firstName = ?2")
    public List<Contact> findByEmailAndFullName(String email, String firstName);

    @Query(value = "SELECT c FROM Contact c WHERE c.email = ?1")
    public Contact existsContactByEmail(String email);
}
