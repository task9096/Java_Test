package com.rs.hospital.repository;

import com.rs.hospital.model.PurchaseOrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderHistoryRepository extends JpaRepository<PurchaseOrderHistory, Long> {

}
