package com.rs.hospital.controller;


import com.rs.hospital.dto.OpportunityActivityDTO;

import com.rs.hospital.service.OpportunityActivityServiceImpl;
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
public class OpportunityActivityController{
    @Autowired
    private OpportunityActivityServiceImpl opportunityActivityImpl;

    @PostMapping(value="/opportunityActivity",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<OpportunityActivityDTO> addOpportunityActivity(@RequestBody OpportunityActivityDTO opportunityActivity) {

        OpportunityActivityDTO opportunityActivityDTO = opportunityActivityImpl.save(opportunityActivity);
        return ResponseEntity.ok().body(opportunityActivityDTO);
    }

    @PutMapping(value="/opportunityActivity/{id}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<OpportunityActivityDTO> updateOpportunityActivity(@RequestBody OpportunityActivityDTO opportunityActivity
            ,  @PathVariable("id") long opportunityActivityId) throws Exception {

        OpportunityActivityDTO empDTO = opportunityActivityImpl.update(opportunityActivity, opportunityActivityId);
        return ResponseEntity.ok().body(empDTO);
    }

    @DeleteMapping(value="/opportunityActivity/{id}")
    public Map<String, Boolean> deleteOpportunityActivity(@PathVariable long id) throws Exception{
        return opportunityActivityImpl.delete(id);
    }

    @GetMapping(value="/opportunityActivity/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<OpportunityActivityDTO> findById(@PathVariable long id) throws Exception {

        OpportunityActivityDTO opportunityActivityDTO = opportunityActivityImpl.getById(id);
        return ResponseEntity.ok().body(opportunityActivityDTO);
    }

    @GetMapping(value="/opportunityActivity")
    public ResponseEntity<List<OpportunityActivityDTO>> listAll()
    {
        List<OpportunityActivityDTO> opportunityActivityDTO = opportunityActivityImpl.getAll();
        return ResponseEntity.ok().body(opportunityActivityDTO);
    }

    @PostMapping(value="/opportunityActivity/check")
    public ResponseEntity<Map<String, Boolean>> isExists(@RequestBody OpportunityActivityDTO opportunityActivityDTO){
        Map<String, Boolean> res = new HashMap<>();
        if(opportunityActivityImpl.isExists(opportunityActivityDTO)) {
            res.put("available", Boolean.TRUE);
        }else {
            res.put("available", Boolean.FALSE);
        }

        return ResponseEntity.ok().body(res);
    }

    @GetMapping(value="/opportunity/{opportunityId}/customerName", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<String> findCustomerNameById(@PathVariable long opportunityId) throws Exception {

        String customerName = opportunityActivityImpl.findCustomerNameById(opportunityId);
        return ResponseEntity.ok().body(customerName);
    }

}

