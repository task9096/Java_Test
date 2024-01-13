package com.rs.hospital.repository;

import com.rs.hospital.dto.CustomerLeadDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerLeadNativeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<CustomerLeadDTO> findAllCustomerLeadForSalesOrder() {
        String sqlQuery = "SELECT new com.rs.hospital.dto.CustomerLeadDTO(cl.id, cl.categoryId, cl.customerId, cl.dealerId, cl.note, cl.remark, cl.source, cl.statusId, cl.statusName, lp.productId, lp.quantity, lp.modelId, lp.price, lp.amount, c.categoryName, p.productName, pm.modelName,cu.fullName) " +
                "FROM CustomerLead cl " +
                "INNER JOIN Customer cu ON cl.customerId = cu.id " +
                "INNER JOIN LeadProduct lp ON lp.leadId = cl.id " +
                "INNER JOIN Category c ON cl.categoryId = c.id " +
                "INNER JOIN Product p ON lp.productId = p.id " +
                "INNER JOIN ProductModel pm ON lp.modelId = pm.id " +
                "INNER JOIN Opportunity o ON o.leadId = cl.id " +
                "INNER JOIN OpportunityActivity oa ON oa.opportunityId = o.id where oa.status = 'Completed'";

        TypedQuery<CustomerLeadDTO> query = entityManager.createQuery(sqlQuery, CustomerLeadDTO.class);

        List<CustomerLeadDTO> resultList = query.getResultList();

        return resultList;
    }

    public List<CustomerLeadDTO> findAllCustomerLeadForOpportunity() {
        String sqlQuery = "SELECT new com.rs.hospital.dto.CustomerLeadDTO(cl.id, cl.categoryId, cl.customerId, cl.dealerId, cl.note, cl.remark, cl.source, cl.statusId, cl.statusName, lp.productId, lp.quantity, lp.modelId, lp.price, lp.amount, c.categoryName, p.productName, pm.modelName,cu.fullName) " +
                "FROM CustomerLead cl " +
                "INNER JOIN Customer cu ON cl.customerId = cu.id " +
                "INNER JOIN LeadProduct lp ON lp.leadId = cl.id " +
                "INNER JOIN Category c ON cl.categoryId = c.id " +
                "INNER JOIN Product p ON lp.productId = p.id " +
                "INNER JOIN ProductModel pm ON lp.modelId = pm.id where cl.statusName = 'Approved'" ;

        TypedQuery<CustomerLeadDTO> query = entityManager.createQuery(sqlQuery, CustomerLeadDTO.class);

        List<CustomerLeadDTO> resultList = query.getResultList();

        return resultList;
    }
}