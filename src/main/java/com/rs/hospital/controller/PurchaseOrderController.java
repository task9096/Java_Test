package com.rs.hospital.controller;


import com.rs.hospital.dto.PurchaseOrderDTO;

import com.rs.hospital.service.PurchaseOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/api")
//@PreAuthorize("hasRole('ADMIN')")
public class PurchaseOrderController{
    @Autowired
    private PurchaseOrderServiceImpl purchaseOrderImpl;

    @PostMapping(value="/purchaseOrder",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<PurchaseOrderDTO> addPurchaseOrder(@RequestBody PurchaseOrderDTO purchaseOrder) {

        PurchaseOrderDTO purchaseOrderDTO = purchaseOrderImpl.save(purchaseOrder);
        return ResponseEntity.ok().body(purchaseOrderDTO);
    }

    @PutMapping(value="/purchaseOrder/{id}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<PurchaseOrderDTO> updatePurchaseOrder(@RequestBody PurchaseOrderDTO purchaseOrder
            ,  @PathVariable("id") long purchaseOrderId) throws Exception {

        PurchaseOrderDTO empDTO = purchaseOrderImpl.update(purchaseOrder, purchaseOrderId);
        return ResponseEntity.ok().body(empDTO);
    }

    @DeleteMapping(value="/purchaseOrder/{id}")
    public Map<String, Boolean> deletePurchaseOrder(@PathVariable long id) throws Exception{
        return purchaseOrderImpl.delete(id);
    }

    @GetMapping(value="/purchaseOrder/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<PurchaseOrderDTO> findById(@PathVariable long id) throws Exception {

        PurchaseOrderDTO purchaseOrderDTO = purchaseOrderImpl.getById(id);
        return ResponseEntity.ok().body(purchaseOrderDTO);
    }

    @GetMapping(value="/purchaseOrder")
    public ResponseEntity<List<PurchaseOrderDTO>> listAll()
    {
        List<PurchaseOrderDTO> purchaseOrderDTO = purchaseOrderImpl.getAll();
        return ResponseEntity.ok().body(purchaseOrderDTO);
    }

    @GetMapping(value="/purchaseOrder/customer/{id}")
    public ResponseEntity<List<PurchaseOrderDTO>> listAllByLoginCustomer(@PathVariable long id)
    {
        List<PurchaseOrderDTO> purchaseOrderDTO = purchaseOrderImpl.listAllByLoginCustomer(id);
        return ResponseEntity.ok().body(purchaseOrderDTO);
    }

    @GetMapping(value="/purchaseOrder/approved")
    public ResponseEntity<List<PurchaseOrderDTO>> listAllApproved()
    {
        List<PurchaseOrderDTO> purchaseOrderDTO = purchaseOrderImpl.getAllApproved();
        return ResponseEntity.ok().body(purchaseOrderDTO);
    }



    @PostMapping(value="/purchaseOrder/check")
    public ResponseEntity<Map<String, Boolean>> isExists(@RequestBody PurchaseOrderDTO purchaseOrderDTO){
        Map<String, Boolean> res = new HashMap<>();
        /*if(purchaseOrderImpl.isExists(purchaseOrderDTO)) {
            res.put("available", Boolean.TRUE);
        }else {
            res.put("available", Boolean.FALSE);
        }
*/
        return ResponseEntity.ok().body(res);
    }

}

