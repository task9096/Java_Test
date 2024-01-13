package com.rs.hospital.controller;


import com.rs.hospital.dto.CustomerDTO;

import com.rs.hospital.service.CustomerServiceImpl;
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
public class CustomerController{
    @Autowired
    private CustomerServiceImpl customerImpl;

    @PostMapping(value="/customer",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customer) {

        CustomerDTO customerDTO = customerImpl.save(customer);
        return ResponseEntity.ok().body(customerDTO);
    }

    @PutMapping(value="/customer/{id}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customer
            ,  @PathVariable("id") long customerId) throws Exception {

        CustomerDTO empDTO = customerImpl.update(customer, customerId);
        return ResponseEntity.ok().body(empDTO);
    }

    @DeleteMapping(value="/customer/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable long id) throws Exception{
        return customerImpl.delete(id);
    }

    @GetMapping(value="/customer/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<CustomerDTO> findById(@PathVariable long id) throws Exception {

        CustomerDTO customerDTO = customerImpl.getById(id);
        return ResponseEntity.ok().body(customerDTO);
    }

    @GetMapping(value="/customer")
    public ResponseEntity<List<CustomerDTO>> listAll()
    {
        List<CustomerDTO> customerDTO = customerImpl.getAll();
        return ResponseEntity.ok().body(customerDTO);
    }

    @PostMapping(value="/customer/check")
    public ResponseEntity<Map<String, Boolean>> isExists(@RequestBody CustomerDTO customerDTO){
        Map<String, Boolean> res = new HashMap<>();
        if(customerImpl.isExists(customerDTO)) {
            res.put("available", Boolean.TRUE);
        }else {
            res.put("available", Boolean.FALSE);
        }

        return ResponseEntity.ok().body(res);
    }

    @GetMapping(value="/customer/user/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<CustomerDTO> findProfileByUserId(@PathVariable long id) throws Exception {

        CustomerDTO customerDTO = customerImpl.profileByUserId(id);
        return ResponseEntity.ok().body(customerDTO);
    }

}

