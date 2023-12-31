package com.rs.hospital.controller;

import com.rs.hospital.dto.ProductDTO;
import com.rs.hospital.dto.SalesOrderDTO;
import com.rs.hospital.model.SalesOrder;
import com.rs.hospital.service.SalesOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
//@PreAuthorize("hasRole('ADMIN')")
public class SalesOrderDTOController {
    @Autowired
    private SalesOrderServiceImpl salesOrderServiceImpl;

    @GetMapping(value="/salesOrder/lead/{leadId}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<SalesOrderDTO> getSalesOrder(@PathVariable("leadId") long leadId) throws Exception {

        SalesOrderDTO salesOrderDTO = salesOrderServiceImpl.getSalesOrderByLeadId(leadId);
        return ResponseEntity.ok().body(salesOrderDTO);
    }

    @GetMapping(value="/salesOrder/add/lead/{leadId}/user/{userId}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<String> addSalesOrder(@PathVariable("leadId") long leadId, @PathVariable("userId") long userId) throws Exception {

        String salesOrderDTO = salesOrderServiceImpl.addSalesOrderByLeadId(leadId,userId);
        return ResponseEntity.ok().body(salesOrderDTO);
    }

    @GetMapping(value="/salesOrder")
    public ResponseEntity<List<SalesOrder>> listAll()
    {
        List<SalesOrder> salesOrders = salesOrderServiceImpl.getAll();
        return ResponseEntity.ok().body(salesOrders);
    }

}
