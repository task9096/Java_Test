package com.rs.hospital.controller;


import com.rs.hospital.dto.CustomerLeadDTO;

import com.rs.hospital.service.CustomerLeadServiceImpl;
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
public class CustomerLeadController{
    @Autowired
    private CustomerLeadServiceImpl customerLeadImpl;

    @PostMapping(value="/customerLead",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<CustomerLeadDTO> addCustomerLead(@RequestBody CustomerLeadDTO customerLead) {

        CustomerLeadDTO customerLeadDTO = customerLeadImpl.save(customerLead);
        return ResponseEntity.ok().body(customerLeadDTO);
    }

    @PutMapping(value="/customerLead/{id}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<CustomerLeadDTO> updateCustomerLead(@RequestBody CustomerLeadDTO customerLead
            ,  @PathVariable("id") long customerLeadId) throws Exception {

        CustomerLeadDTO empDTO = customerLeadImpl.update(customerLead, customerLeadId);
        return ResponseEntity.ok().body(empDTO);
    }

    @DeleteMapping(value="/customerLead/{id}")
    public Map<String, Boolean> deleteCustomerLead(@PathVariable long id) throws Exception{
        return customerLeadImpl.delete(id);
    }

    @GetMapping(value="/customerLead/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<CustomerLeadDTO> findById(@PathVariable long id) throws Exception {

        CustomerLeadDTO customerLeadDTO = customerLeadImpl.getById(id);
        return ResponseEntity.ok().body(customerLeadDTO);
    }

    @GetMapping(value="/customerLead")
    public ResponseEntity<List<CustomerLeadDTO>> listAll()
    {
        List<CustomerLeadDTO> customerLeadDTO = customerLeadImpl.getAll();
        return ResponseEntity.ok().body(customerLeadDTO);
    }

    @GetMapping(value="/customerLead/salesOrder")
    public ResponseEntity<List<CustomerLeadDTO>> listAllForSalesOrder()
    {
        List<CustomerLeadDTO> customerLeadDTO = customerLeadImpl.listAllForSalesOrder();
        return ResponseEntity.ok().body(customerLeadDTO);
    }

    @GetMapping(value="/customerLead/opportunity")
    public ResponseEntity<List<CustomerLeadDTO>> listAllForOpportunity()
    {
        List<CustomerLeadDTO> customerLeadDTO = customerLeadImpl.listAllForOpportunity();
        return ResponseEntity.ok().body(customerLeadDTO);
    }


    @PostMapping(value="/customerLead/check")
    public ResponseEntity<Map<String, Boolean>> isExists(@RequestBody CustomerLeadDTO customerLeadDTO){
        Map<String, Boolean> res = new HashMap<>();
        if(customerLeadImpl.isExists(customerLeadDTO)) {
            res.put("available", Boolean.TRUE);
        }else {
            res.put("available", Boolean.FALSE);
        }

        return ResponseEntity.ok().body(res);
    }

}

