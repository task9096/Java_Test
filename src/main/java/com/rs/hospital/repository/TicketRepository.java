package com.rs.hospital.repository;

import com.rs.hospital.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketRepository  extends JpaRepository<Ticket, Long> {
    @Query("SELECT c FROM Ticket c WHERE c.email = ?1")
    public Ticket findByEmail(String email);

    /*@Query("SELECT c FROM Ticket c WHERE c.email = ?1 and c.firstName = ?2")
    public List<Ticket> findByEmailAndFullName(String email, String firstName);
*/
    @Query(value = "SELECT c FROM Ticket c WHERE c.email = ?1")
    public Ticket existsTicketByEmail(String email);
}
