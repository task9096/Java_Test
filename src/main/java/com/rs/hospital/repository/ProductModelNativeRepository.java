package com.rs.hospital.repository;

import com.rs.hospital.dto.ProductModelDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductModelNativeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<ProductModelDTO> findAllProductModelWithProduct() {
        String sqlQuery = "SELECT new com.rs.hospital.dto.ProductModelDTO(pm.id, pm.productId, pm.modelNumber, pm.modelName, pm.price, pm.imageUrl, pm.stock, p.productName) " +
                "FROM ProductModel pm " +
                "INNER JOIN Product p ON pm.productId = p.id";

        TypedQuery<ProductModelDTO> query = entityManager.createQuery(sqlQuery, ProductModelDTO.class);

        List<ProductModelDTO> resultList = query.getResultList();

        return resultList;
    }
}