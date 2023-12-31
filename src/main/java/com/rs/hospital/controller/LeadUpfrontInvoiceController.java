package com.rs.hospital.controller;


import com.rs.hospital.dto.LeadUpfrontInvoiceDTO;

import com.rs.hospital.service.LeadUpfrontInvoiceServiceImpl;
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
public class LeadUpfrontInvoiceController{
    @Autowired
    private LeadUpfrontInvoiceServiceImpl leadUpfrontInvoiceImpl;

    @PostMapping(value="/leadUpfrontInvoice",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<LeadUpfrontInvoiceDTO> addLeadUpfrontInvoice(@RequestBody LeadUpfrontInvoiceDTO leadUpfrontInvoice) {

        LeadUpfrontInvoiceDTO leadUpfrontInvoiceDTO = leadUpfrontInvoiceImpl.save(leadUpfrontInvoice);
        return ResponseEntity.ok().body(leadUpfrontInvoiceDTO);
    }

    @PutMapping(value="/leadUpfrontInvoice/{id}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<LeadUpfrontInvoiceDTO> updateLeadUpfrontInvoice(@RequestBody LeadUpfrontInvoiceDTO leadUpfrontInvoice
            ,  @PathVariable("id") long leadUpfrontInvoiceId) throws Exception {

        LeadUpfrontInvoiceDTO empDTO = leadUpfrontInvoiceImpl.update(leadUpfrontInvoice, leadUpfrontInvoiceId);
        return ResponseEntity.ok().body(empDTO);
    }

    @DeleteMapping(value="/leadUpfrontInvoice/{id}")
    public Map<String, Boolean> deleteLeadUpfrontInvoice(@PathVariable long id) throws Exception{
        return leadUpfrontInvoiceImpl.delete(id);
    }

    @GetMapping(value="/leadUpfrontInvoice/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<LeadUpfrontInvoiceDTO> findById(@PathVariable long id) throws Exception {

        LeadUpfrontInvoiceDTO leadUpfrontInvoiceDTO = leadUpfrontInvoiceImpl.getById(id);
        return ResponseEntity.ok().body(leadUpfrontInvoiceDTO);
    }

    @GetMapping(value="/leadUpfrontInvoice")
    public ResponseEntity<List<LeadUpfrontInvoiceDTO>> listAll()
    {
        List<LeadUpfrontInvoiceDTO> leadUpfrontInvoiceDTO = leadUpfrontInvoiceImpl.getAll();
        return ResponseEntity.ok().body(leadUpfrontInvoiceDTO);
    }

    @GetMapping(value="/leadUpfrontInvoice/invoice/{invoiceId}")
    public ResponseEntity<List<LeadUpfrontInvoiceDTO>> listAllByInvoiceId(@PathVariable long invoiceId)
    {
        List<LeadUpfrontInvoiceDTO> leadUpfrontInvoiceDTO = leadUpfrontInvoiceImpl.getAllByInvoiceId(invoiceId);
        return ResponseEntity.ok().body(leadUpfrontInvoiceDTO);
    }

    @PostMapping(value="/leadUpfrontInvoice/check")
    public ResponseEntity<Map<String, Boolean>> isExists(@RequestBody LeadUpfrontInvoiceDTO leadUpfrontInvoiceDTO){
        Map<String, Boolean> res = new HashMap<>();
        if(leadUpfrontInvoiceImpl.isExists(leadUpfrontInvoiceDTO)) {
            res.put("available", Boolean.TRUE);
        }else {
            res.put("available", Boolean.FALSE);
        }

        return ResponseEntity.ok().body(res);
    }

}

