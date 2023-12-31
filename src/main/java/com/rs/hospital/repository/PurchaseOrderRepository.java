package com.rs.hospital.repository;

import com.rs.hospital.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

    @Query("SELECT c FROM PurchaseOrder c WHERE c.status = 'Approve' and c.clientStatus = 'Approve'")
    public List<PurchaseOrder> findAllApproved();
}
