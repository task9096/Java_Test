package com.rs.hospital.controller;


import com.rs.hospital.dto.OpportunityDTO;

import com.rs.hospital.service.OpportunityServiceImpl;
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
public class OpportunityController{
    @Autowired
    private OpportunityServiceImpl opportunityImpl;

    @PostMapping(value="/opportunity",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<OpportunityDTO> addOpportunity(@RequestBody OpportunityDTO opportunity) {

        OpportunityDTO opportunityDTO = opportunityImpl.save(opportunity);
        return ResponseEntity.ok().body(opportunityDTO);
    }

    @PutMapping(value="/opportunity/{id}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<OpportunityDTO> updateOpportunity(@RequestBody OpportunityDTO opportunity
            ,  @PathVariable("id") long opportunityId) throws Exception {

        OpportunityDTO empDTO = opportunityImpl.update(opportunity, opportunityId);
        return ResponseEntity.ok().body(empDTO);
    }

    @DeleteMapping(value="/opportunity/{id}")
    public Map<String, Boolean> deleteOpportunity(@PathVariable long id) throws Exception{
        return opportunityImpl.delete(id);
    }

    @GetMapping(value="/opportunity/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<OpportunityDTO> findById(@PathVariable long id) throws Exception {

        OpportunityDTO opportunityDTO = opportunityImpl.getById(id);
        return ResponseEntity.ok().body(opportunityDTO);
    }

    @GetMapping(value="/opportunity")
    public ResponseEntity<List<OpportunityDTO>> listAll()
    {
        List<OpportunityDTO> opportunityDTO = opportunityImpl.getAll();
        return ResponseEntity.ok().body(opportunityDTO);
    }

    @PostMapping(value="/opportunity/check")
    public ResponseEntity<Map<String, Boolean>> isExists(@RequestBody OpportunityDTO opportunityDTO){
        Map<String, Boolean> res = new HashMap<>();
        if(opportunityImpl.isExists(opportunityDTO)) {
            res.put("available", Boolean.TRUE);
        }else {
            res.put("available", Boolean.FALSE);
        }

        return ResponseEntity.ok().body(res);
    }

}

