package com.rs.hospital.controller;

import com.rs.hospital.dto.BusinessDTO;
import com.rs.hospital.service.BusinessServiceImpl;
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
public class BusinessController{
    @Autowired
    private BusinessServiceImpl businessImpl;

    @PostMapping(value="/business",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<BusinessDTO> addBusiness(@RequestBody BusinessDTO business) {

        BusinessDTO businessDTO = businessImpl.save(business);
        return ResponseEntity.ok().body(businessDTO);
    }

    @PutMapping(value="/business/{id}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<BusinessDTO> updateBusiness(@RequestBody BusinessDTO business
            ,  @PathVariable("id") long businessId) throws Exception {

        BusinessDTO businessDTO = businessImpl.update(business, businessId);
        return ResponseEntity.ok().body(businessDTO);
    }

    @DeleteMapping(value="/business/{id}")
    public Map<String, Boolean> deleteBusiness(@PathVariable long id) throws Exception{
        return businessImpl.delete(id);
    }

    @GetMapping(value="/business/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<BusinessDTO> findById(@PathVariable long id) throws Exception {

        BusinessDTO businessDTO = businessImpl.getById(id);
        return ResponseEntity.ok().body(businessDTO);
    }

    @GetMapping(value="/business")
    public ResponseEntity<List<BusinessDTO>> listAll()
    {
        List<BusinessDTO> businessDTO = businessImpl.getAll();
        return ResponseEntity.ok().body(businessDTO);
    }

    @PostMapping(value="/business/check")
    public ResponseEntity<Map<String, Boolean>> isExists(@RequestBody BusinessDTO businessDTO){
        Map<String, Boolean> res = new HashMap<>();
        if(businessImpl.isExists(businessDTO)) {
            res.put("available", Boolean.TRUE);
        }else {
            res.put("available", Boolean.FALSE);
        }

        return ResponseEntity.ok().body(res);
    }

}

