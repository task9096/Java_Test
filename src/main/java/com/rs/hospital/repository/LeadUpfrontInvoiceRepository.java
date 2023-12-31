package com.rs.hospital.repository;

import com.rs.hospital.model.LeadUpfrontInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeadUpfrontInvoiceRepository extends JpaRepository<LeadUpfrontInvoice, Long> {
    @Query("SELECT c FROM LeadUpfrontInvoice c WHERE c.invoiceId = ?1")
    public List<LeadUpfrontInvoice> findByInvoiceId(long invoiceId);
}
