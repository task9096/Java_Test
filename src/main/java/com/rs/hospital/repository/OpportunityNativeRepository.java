package com.rs.hospital.repository;

import com.rs.hospital.dto.OpportunityBean;
import com.rs.hospital.dto.OpportunityDTO;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OpportunityNativeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<OpportunityDTO> findAllOpportunitiesWithCustomerName1() {
        String sqlQuery = "SELECT new com.rs.hospital.dto.OpportunityDTO(o.id, o.leadId, o.opportunityName, o.accountName, o.productCategory, o.quantity, o.expectedAmount, o.expectedCloseDate, o.salesStage, o.followupDate, o.extQuotationUrl, o.comments, o.leadSource, c.fullName) " +
                "FROM Opportunity o " +
                "INNER JOIN CustomerLead l ON o.leadId = l.id " +
                "INNER JOIN Customer c ON l.customerId = c.id";

        TypedQuery<OpportunityDTO> query = entityManager.createQuery(sqlQuery, OpportunityDTO.class);

        List<OpportunityDTO> resultList = query.getResultList();

        return resultList;
    }
}
