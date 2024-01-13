package com.rs.hospital.repository;

import com.rs.hospital.dto.InvoiceBillDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class InvoiceBillNativeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public InvoiceBillDTO getInvoiceBill(Long invoiceId) {
        String sqlQuery = "SELECT new com.rs.hospital.dto.InvoiceBillDTO(c.fullName, c.email, c.address, c.mobileNo, c.deliveryAddress, c.title, c.pincode, c.state, c.city, lp.quantity, cat.categoryName, p.productName, pm.modelNumber, pm.modelName, pm.price, pm.imageUrl, s.totalAmount, po.salesPrices, po.finalPrice, po.discount, po.gst, po.poNumber, i.totalDueAmount, i.invoiceDate, i.invoiceNumber) " +
                "FROM Invoice i " +
                "INNER JOIN PurchaseOrder po ON i.purchaseOrderId = po.id " +
                "INNER JOIN SalesOrder s ON po.salesOrderId = s.id " +
                "INNER JOIN CustomerLead l ON s.leadId = l.id " +
                "INNER JOIN LeadProduct lp ON s.leadId = lp.leadId " +
                "INNER JOIN Category cat ON l.categoryId = cat.id " +
                "INNER JOIN Product p ON p.id = lp.productId " +
                "INNER JOIN ProductModel pm ON pm.id = lp.modelId " +
                "INNER JOIN Customer c ON l.customerId = c.id where i.id = " + invoiceId;

        TypedQuery<InvoiceBillDTO> query = entityManager.createQuery(sqlQuery, InvoiceBillDTO.class);

        InvoiceBillDTO resultList = query.getResultList().get(0);

        return resultList;
    }
}