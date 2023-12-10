package com.rs.hospital.repository;

import com.rs.hospital.model.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DealerRepository extends JpaRepository<Dealer, Long> {
    @Query("SELECT c FROM Dealer c WHERE c.email = ?1")
    public Dealer findByEmail(String email);

    @Query("SELECT c FROM Dealer c WHERE c.email = ?1 and c.fullName = ?2")
    public List<Dealer> findByEmailAndFullName(String email, String fullName);

    @Query(value = "SELECT c FROM Dealer c WHERE c.email = ?1")
    public Dealer existsDealerByEmail(String email);
}
