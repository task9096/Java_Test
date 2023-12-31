package com.rs.hospital.repository;

import com.rs.hospital.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    @Query(value = "SELECT c FROM Invoice c WHERE c.invoiceNumber = ?1")
    public Invoice existsInvoiceByInvoiceNumber(String invoiceNumber);

    @Query(value = "SELECT c FROM Invoice c WHERE c.purchaseOrderId = ?1")
    public Invoice existsInvoiceByPurchaseOrderId(String purchaseOrderId);
}
