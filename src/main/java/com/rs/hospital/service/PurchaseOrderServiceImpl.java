package com.rs.hospital.service;

import com.rs.hospital.dto.PurchaseOrderDTO;
import com.rs.hospital.dto.SalesOrderDTO;
import com.rs.hospital.model.PurchaseOrder;
import com.rs.hospital.model.PurchaseOrderHistory;
import com.rs.hospital.model.SalesOrder;
import com.rs.hospital.repository.PurchaseOrderHistoryRepository;
import com.rs.hospital.repository.PurchaseOrderNativeRepository;
import com.rs.hospital.repository.PurchaseOrderRepository;
import com.rs.hospital.repository.SalesOrderRepository;
import com.rs.hospital.utility.PoNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService{

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    @Autowired
    private PurchaseOrderRepository repo;

    @Autowired
    private PurchaseOrderHistoryRepository purchaseOrderHistoryRepository;

    @Autowired
    private SalesOrderService salesOrderService;

    @Autowired
    private PurchaseOrderNativeRepository purchaseOrderNativeRepository;

    @Override
    public PurchaseOrderDTO getPurchaseOrderBySalesOrderId(Long salesOrderId) {
        SalesOrder salesOrder = salesOrderRepository.findById(salesOrderId).get();
        SalesOrderDTO salesOrderDTO = salesOrderService.getSalesOrderByLeadId(salesOrder.getLeadId());
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        getPurchaseOrderDTOBySalesOrderDTO(purchaseOrderDTO,salesOrderDTO);
        return purchaseOrderDTO;
    }

    @Override
    public String addPurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) {
        return null;
    }


    private void getPurchaseOrderDTOBySalesOrderDTO(PurchaseOrderDTO purchaseOrderDTO,SalesOrderDTO salesOrderDTO){
        purchaseOrderDTO.setSalesOrderId(salesOrderDTO.getId());
        purchaseOrderDTO.setSalesPrices(salesOrderDTO.getAmount());
    }

    /**
     *
     * @param purchaseOrderDTO
     * @return
     *
     * Steps
     * 1	Convert DTO to model
     * 2	make all opertions = > CRUD
     * 3	convert model to dto
     */
    /*
     * Convert PurchaseOrder DTO class to PurchaseOrder Model Class
     */
    private PurchaseOrder convertDTOtoModel(PurchaseOrderDTO purchaseOrderDTO) {

        PurchaseOrder purchaseOrder = new PurchaseOrder();

        purchaseOrder.setId(purchaseOrderDTO.getId());
        purchaseOrder.setClientStatus(purchaseOrderDTO.getClientStatus());
        purchaseOrder.setClientStatusDate(purchaseOrderDTO.getClientStatusDate());
        purchaseOrder.setCreatedDate(purchaseOrderDTO.getCreatedDate());
        purchaseOrder.setDiscount(purchaseOrderDTO.getDiscount());
        purchaseOrder.setFinalPrice(purchaseOrderDTO.getFinalPrice());
        purchaseOrder.setGst(purchaseOrderDTO.getGst());
        purchaseOrder.setLeadId(purchaseOrderDTO.getLeadId());
        purchaseOrder.setPoNumber(purchaseOrderDTO.getPoNumber());
        purchaseOrder.setSalesOrderId(purchaseOrderDTO.getSalesOrderId());
        purchaseOrder.setUserId(purchaseOrderDTO.getUserId());
        purchaseOrder.setUpdatedUserId(purchaseOrderDTO.getUpdatedUserId());
        purchaseOrder.setStatus(purchaseOrderDTO.getStatus());
        purchaseOrder.setStatusDate(purchaseOrderDTO.getStatusDate());
        purchaseOrder.setSalesPrices(purchaseOrderDTO.getSalesPrices());
        return purchaseOrder;
    }

    /*
     * Convert Model To DTO
     */
    private PurchaseOrderDTO convertModelToDTO(PurchaseOrder purchaseOrder) {
        return new PurchaseOrderDTO(purchaseOrder);
    }

    @Override
    public PurchaseOrderDTO save(PurchaseOrderDTO PurchaseOrderDTO) {
        PurchaseOrder purchaseOrder = convertDTOtoModel(PurchaseOrderDTO); // convert dto to model for database interaction
        purchaseOrder.setPoNumber(new PoNumberGenerator().generatePoNumber());
        purchaseOrder = repo.save(purchaseOrder);
        savePurchaseOrderHistory(purchaseOrder,purchaseOrder.getStatus(),purchaseOrder.getCreatedDate());
        return convertModelToDTO(purchaseOrder); // return DTO
    }

    @Override
    public PurchaseOrderDTO update(PurchaseOrderDTO purchaseOrderDTO, long bid) throws Exception {

        PurchaseOrderDTO copyPurchaseOrder = getById(bid);

        copyPurchaseOrder.setId(purchaseOrderDTO.getId());
        copyPurchaseOrder.setClientStatus(purchaseOrderDTO.getClientStatus());
        copyPurchaseOrder.setClientStatusDate(purchaseOrderDTO.getClientStatusDate());
        copyPurchaseOrder.setCreatedDate(purchaseOrderDTO.getCreatedDate());
        copyPurchaseOrder.setDiscount(purchaseOrderDTO.getDiscount());
        copyPurchaseOrder.setFinalPrice(purchaseOrderDTO.getFinalPrice());
        copyPurchaseOrder.setGst(purchaseOrderDTO.getGst());
        copyPurchaseOrder.setLeadId(purchaseOrderDTO.getLeadId());
        copyPurchaseOrder.setPoNumber(purchaseOrderDTO.getPoNumber());
        copyPurchaseOrder.setSalesOrderId(purchaseOrderDTO.getSalesOrderId());
        copyPurchaseOrder.setUserId(purchaseOrderDTO.getUserId());
        copyPurchaseOrder.setUpdatedUserId(purchaseOrderDTO.getUpdatedUserId());
        copyPurchaseOrder.setStatus(purchaseOrderDTO.getStatus());
        copyPurchaseOrder.setStatusDate(purchaseOrderDTO.getStatusDate());
        copyPurchaseOrder.setSalesPrices(purchaseOrderDTO.getSalesPrices());


        // step 1
        PurchaseOrder purchaseOrder = convertDTOtoModel(copyPurchaseOrder);

        //step 2

        // step 3
        purchaseOrder = repo.save(purchaseOrder);
        savePurchaseOrderHistory(purchaseOrder,purchaseOrder.getStatus(),purchaseOrder.getCreatedDate());
        return convertModelToDTO(purchaseOrder);
    }

    @Override
    public PurchaseOrderDTO getById(long bid) throws Exception {
        PurchaseOrder purchaseOrder = repo.findById(bid)
                .orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + bid));
        return convertModelToDTO(purchaseOrder);
    }

    @Override
    public List<PurchaseOrderDTO> getAll() {
        List<PurchaseOrder> purchaseOrderList = repo.findAll();
        //List<PurchaseOrderDTO> purchaseOrderDTOList = new ArrayList<>();

        List<PurchaseOrderDTO> purchaseOrderDTOList = purchaseOrderNativeRepository.findAllPurchaseOrderWithCustomerName();

        /*for(PurchaseOrder PurchaseOrder : purchaseOrderList) {
            purchaseOrderDTOList.add(convertModelToDTO(PurchaseOrder));
        }*/

        return purchaseOrderDTOList;
    }

    @Override
    public List<PurchaseOrderDTO> listAllByLoginCustomer(long userId) {
        List<PurchaseOrder> purchaseOrderList = repo.findAll();
        //List<PurchaseOrderDTO> purchaseOrderDTOList = new ArrayList<>();

        List<PurchaseOrderDTO> purchaseOrderDTOList = purchaseOrderNativeRepository.findAllPurchaseOrderByLoginCustomer(userId);

        /*for(PurchaseOrder PurchaseOrder : purchaseOrderList) {
            purchaseOrderDTOList.add(convertModelToDTO(PurchaseOrder));
        }*/

        return purchaseOrderDTOList;
    }

    @Override
    public List<PurchaseOrderDTO> getAllApproved() {
        /*List<PurchaseOrder> purchaseOrderList = repo.findAllApproved();

        List<PurchaseOrderDTO> purchaseOrderDTOList = new ArrayList<>();

        for(PurchaseOrder PurchaseOrder : purchaseOrderList) {
            purchaseOrderDTOList.add(convertModelToDTO(PurchaseOrder));
        }*/
        List<PurchaseOrderDTO> purchaseOrderDTOList = purchaseOrderNativeRepository.findAllPurchaseOrderWithCustomerNameApproved();
        return purchaseOrderDTOList;
    }



    @Override
    public Map<String, Boolean> delete(long bid) throws Exception {
        PurchaseOrder purchaseOrder = convertDTOtoModel(getById(bid));
        repo.delete(purchaseOrder);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Delete", Boolean.TRUE);

        return response;

    }

    private void savePurchaseOrderHistory(PurchaseOrder purchaseOrder, String activity, LocalDate activityDate){
        PurchaseOrderHistory purchaseOrderHistory = new PurchaseOrderHistory();
        purchaseOrderHistory.setPurchaseOrderId(purchaseOrder.getId());
        purchaseOrderHistory.setUserId(purchaseOrder.getUserId());
        purchaseOrderHistory.setActivity(activity);
        purchaseOrderHistory.setActivityDate(activityDate);
        purchaseOrderHistoryRepository.save(purchaseOrderHistory);
    }


}
