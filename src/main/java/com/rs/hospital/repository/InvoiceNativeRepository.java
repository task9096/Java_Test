package com.rs.hospital.repository;

import com.rs.hospital.dto.InvoiceDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class InvoiceNativeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<InvoiceDTO> findAllInvoiceWithCustomerName() {
        String sqlQuery = "SELECT new com.rs.hospital.dto.InvoiceDTO(i.id, i.totalPaidAmount, i.totalDueAmount, i.invoiceDate, i.purchaseOrderId, i.invoiceNumber, c.fullName) " +
                "FROM Invoice i  " +
                "INNER JOIN PurchaseOrder po ON i.purchaseOrderId = po.id " +
                "INNER JOIN CustomerLead l ON po.leadId = l.id " +
                "INNER JOIN LeadProduct lp ON po.leadId = lp.leadId " +
                "INNER JOIN Customer c ON l.customerId = c.id";

        TypedQuery<InvoiceDTO> query = entityManager.createQuery(sqlQuery, InvoiceDTO.class);

        List<InvoiceDTO> resultList = query.getResultList();

        return resultList;
    }
}
