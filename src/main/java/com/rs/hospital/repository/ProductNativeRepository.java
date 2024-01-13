package com.rs.hospital.repository;

import com.rs.hospital.dto.ProductDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductNativeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<ProductDTO> findAllProductWithCategory() {
        String sqlQuery = "SELECT new com.rs.hospital.dto.ProductDTO(p.id, p.categoryId, p.productName, c.categoryName) " +
                "FROM Product p " +
                "INNER JOIN Category c ON p.categoryId = c.id";

        TypedQuery<ProductDTO> query = entityManager.createQuery(sqlQuery, ProductDTO.class);

        List<ProductDTO> resultList = query.getResultList();

        return resultList;
    }
}