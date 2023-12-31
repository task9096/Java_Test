package com.rs.hospital.controller;


import com.rs.hospital.dto.InvoiceDTO;

import com.rs.hospital.service.InvoiceServiceImpl;
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
public class InvoiceController{
    @Autowired
    private InvoiceServiceImpl invoiceImpl;

    @PostMapping(value="/invoice",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<InvoiceDTO> addInvoice(@RequestBody InvoiceDTO invoice) {

        InvoiceDTO invoiceDTO = invoiceImpl.save(invoice);
        return ResponseEntity.ok().body(invoiceDTO);
    }

    @PutMapping(value="/invoice/{id}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<InvoiceDTO> updateInvoice(@RequestBody InvoiceDTO invoice
            ,  @PathVariable("id") long invoiceId) throws Exception {

        InvoiceDTO empDTO = invoiceImpl.update(invoice, invoiceId);
        return ResponseEntity.ok().body(empDTO);
    }

    @DeleteMapping(value="/invoice/{id}")
    public Map<String, Boolean> deleteInvoice(@PathVariable long id) throws Exception{
        return invoiceImpl.delete(id);
    }

    @GetMapping(value="/invoice/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<InvoiceDTO> findById(@PathVariable long id) throws Exception {

        InvoiceDTO invoiceDTO = invoiceImpl.getById(id);
        return ResponseEntity.ok().body(invoiceDTO);
    }

    @GetMapping(value="/invoice")
    public ResponseEntity<List<InvoiceDTO>> listAll()
    {
        List<InvoiceDTO> invoiceDTO = invoiceImpl.getAll();
        return ResponseEntity.ok().body(invoiceDTO);
    }

    @PostMapping(value="/invoice/check")
    public ResponseEntity<Map<String, Boolean>> isExists(@RequestBody InvoiceDTO invoiceDTO){
        Map<String, Boolean> res = new HashMap<>();
        if(invoiceImpl.isExists(invoiceDTO)) {
            res.put("available", Boolean.TRUE);
        }else {
            res.put("available", Boolean.FALSE);
        }

        return ResponseEntity.ok().body(res);
    }

}

