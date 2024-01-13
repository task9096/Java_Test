package com.rs.hospital.service;

import com.rs.hospital.dto.PurchaseOrderDTO;

import java.util.List;
import java.util.Map;

public interface PurchaseOrderService {
    public PurchaseOrderDTO getPurchaseOrderBySalesOrderId(Long salesOrderId);
    public String addPurchaseOrder(PurchaseOrderDTO purchaseOrderDTO);


    public PurchaseOrderDTO save(PurchaseOrderDTO purchaseOrder);
    public PurchaseOrderDTO update(PurchaseOrderDTO purchaseOrder, long bid) throws Exception;
    public PurchaseOrderDTO getById(long bid) throws Exception;
    public List<PurchaseOrderDTO> getAll();
    public List<PurchaseOrderDTO> getAllApproved();
    public Map<String, Boolean> delete(long bid) throws Exception;
    public List<PurchaseOrderDTO> listAllByLoginCustomer(long userId);

}
