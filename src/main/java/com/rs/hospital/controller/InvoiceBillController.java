package com.rs.hospital.controller;

import com.rs.hospital.dto.InsuranceDTO;
import com.rs.hospital.dto.InvoiceBillDTO;
import com.rs.hospital.service.InvoiceBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class InvoiceBillController {

    @Autowired
    private InvoiceBillService invoiceBillService;

    @GetMapping(value="/invoiceBill/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<InvoiceBillDTO> findById(@PathVariable long id) throws Exception {

        InvoiceBillDTO invoiceBillDTO =  invoiceBillService.getInvoiceBill(id);
        return ResponseEntity.ok().body(invoiceBillDTO);
    }
}
