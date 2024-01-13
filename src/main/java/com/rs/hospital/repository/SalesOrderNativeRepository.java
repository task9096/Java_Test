package com.rs.hospital.repository;

import com.rs.hospital.dto.SalesOrderDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SalesOrderNativeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<SalesOrderDTO> findAllSalesOrderWithCustomerName() {
        String sqlQuery = "SELECT new com.rs.hospital.dto.SalesOrderDTO(s.id, s.leadId, s.userId, s.totalAmount, s.createdDate, s.status, c.fullName, lp.quantity) " +
                "FROM SalesOrder s " +
                "INNER JOIN CustomerLead l ON s.leadId = l.id " +
                "INNER JOIN LeadProduct lp ON s.leadId = lp.leadId " +
                "INNER JOIN Customer c ON l.customerId = c.id";

        TypedQuery<SalesOrderDTO> query = entityManager.createQuery(sqlQuery, SalesOrderDTO.class);

        List<SalesOrderDTO> resultList = query.getResultList();

        return resultList;
    }

    public List<SalesOrderDTO> findAllSalesOrderByLoginCustomer(long userId) {
        String sqlQuery = "SELECT new com.rs.hospital.dto.SalesOrderDTO(s.id, s.leadId, s.userId, s.totalAmount, s.createdDate, s.status, c.fullName, lp.quantity) " +
                "FROM SalesOrder s " +
                "INNER JOIN CustomerLead l ON s.leadId = l.id " +
                "INNER JOIN LeadProduct lp ON s.leadId = lp.leadId " +
                "INNER JOIN Customer c ON l.customerId = c.id " +
                "INNER JOIN User u ON u.username = c.email where u.id = "+userId;

        TypedQuery<SalesOrderDTO> query = entityManager.createQuery(sqlQuery, SalesOrderDTO.class);

        List<SalesOrderDTO> resultList = query.getResultList();

        return resultList;
    }
}