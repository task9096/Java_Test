package com.rs.hospital.controller;


import com.rs.hospital.dto.DealerDTO;

import com.rs.hospital.service.DealerServiceImpl;
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
public class DealerController{
    @Autowired
    private DealerServiceImpl dealerImpl;

    @PostMapping(value="/dealer",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<DealerDTO> addDealer(@RequestBody DealerDTO dealer) {

        DealerDTO dealerDTO = dealerImpl.save(dealer);
        return ResponseEntity.ok().body(dealerDTO);
    }

    @PutMapping(value="/dealer/{id}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<DealerDTO> updateDealer(@RequestBody DealerDTO dealer
            ,  @PathVariable("id") long dealerId) throws Exception {

        DealerDTO empDTO = dealerImpl.update(dealer, dealerId);
        return ResponseEntity.ok().body(empDTO);
    }

    @DeleteMapping(value="/dealer/{id}")
    public Map<String, Boolean> deleteDealer(@PathVariable long id) throws Exception{
        return dealerImpl.delete(id);
    }

    @GetMapping(value="/dealer/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<DealerDTO> findById(@PathVariable long id) throws Exception {

        DealerDTO dealerDTO = dealerImpl.getById(id);
        return ResponseEntity.ok().body(dealerDTO);
    }

    @GetMapping(value="/dealer")
    public ResponseEntity<List<DealerDTO>> listAll()
    {
        List<DealerDTO> dealerDTO = dealerImpl.getAll();
        return ResponseEntity.ok().body(dealerDTO);
    }

    @PostMapping(value="/dealer/check")
    public ResponseEntity<Map<String, Boolean>> isExists(@RequestBody DealerDTO dealerDTO){
        Map<String, Boolean> res = new HashMap<>();
        if(dealerImpl.isExists(dealerDTO)) {
            res.put("available", Boolean.TRUE);
        }else {
            res.put("available", Boolean.FALSE);
        }

        return ResponseEntity.ok().body(res);
    }

}

