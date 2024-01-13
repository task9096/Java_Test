package com.rs.hospital.repository;

import com.rs.hospital.dto.PurchaseOrderDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PurchaseOrderNativeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<PurchaseOrderDTO> findAllPurchaseOrderWithCustomerName() {
        String sqlQuery = "SELECT new com.rs.hospital.dto.PurchaseOrderDTO(po.id, po.leadId, po.salesOrderId, po.userId, po.updatedUserId, po.salesPrices, po.finalPrice, po.discount, po.gst, po.poNumber, po.createdDate, po.statusDate, po.status, po.clientStatusDate, po.clientStatus, c.fullName, lp.quantity) " +
                "FROM PurchaseOrder po " +
                "INNER JOIN CustomerLead l ON po.leadId = l.id " +
                "INNER JOIN LeadProduct lp ON po.leadId = lp.leadId " +
                "INNER JOIN Customer c ON l.customerId = c.id";

        TypedQuery<PurchaseOrderDTO> query = entityManager.createQuery(sqlQuery, PurchaseOrderDTO.class);

        List<PurchaseOrderDTO> resultList = query.getResultList();

        return resultList;
    }

    public List<PurchaseOrderDTO> findAllPurchaseOrderByLoginCustomer(long userId) {
        String sqlQuery = "SELECT new com.rs.hospital.dto.PurchaseOrderDTO(po.id, po.leadId, po.salesOrderId, po.userId, po.updatedUserId, po.salesPrices, po.finalPrice, po.discount, po.gst, po.poNumber, po.createdDate, po.statusDate, po.status, po.clientStatusDate, po.clientStatus, c.fullName, lp.quantity) " +
                "FROM PurchaseOrder po " +
                "INNER JOIN CustomerLead l ON po.leadId = l.id " +
                "INNER JOIN LeadProduct lp ON po.leadId = lp.leadId " +
                "INNER JOIN Customer c ON l.customerId = c.id " +
                "INNER JOIN User u ON u.username = c.email where u.id = "+userId;

        TypedQuery<PurchaseOrderDTO> query = entityManager.createQuery(sqlQuery, PurchaseOrderDTO.class);

        List<PurchaseOrderDTO> resultList = query.getResultList();

        return resultList;
    }

    public List<PurchaseOrderDTO> findAllPurchaseOrderWithCustomerNameApproved() {
        String sqlQuery = "SELECT new com.rs.hospital.dto.PurchaseOrderDTO(po.id, po.leadId, po.salesOrderId, po.userId, po.updatedUserId, po.salesPrices, po.finalPrice, po.discount, po.gst, po.poNumber, po.createdDate, po.statusDate, po.status, po.clientStatusDate, po.clientStatus, c.fullName, lp.quantity) " +
                "FROM PurchaseOrder po " +
                "INNER JOIN CustomerLead l ON po.leadId = l.id " +
                "INNER JOIN LeadProduct lp ON po.leadId = lp.leadId " +
                "INNER JOIN Customer c ON l.customerId = c.id WHERE po.status = 'Approve' and po.clientStatus = 'Approve'";

        TypedQuery<PurchaseOrderDTO> query = entityManager.createQuery(sqlQuery, PurchaseOrderDTO.class);

        List<PurchaseOrderDTO> resultList = query.getResultList();

        return resultList;
    }
}