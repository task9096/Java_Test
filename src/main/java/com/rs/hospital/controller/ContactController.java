package com.rs.hospital.controller;

import com.rs.hospital.dto.ContactDTO;
import com.rs.hospital.service.ContactServiceImpl;
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
public class ContactController{
    @Autowired
    private ContactServiceImpl contactImpl;

    @PostMapping(value="/contact",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<ContactDTO> addContact(@RequestBody ContactDTO contact) {

        ContactDTO contactDTO = contactImpl.save(contact);
        return ResponseEntity.ok().body(contactDTO);
    }

    @PutMapping(value="/contact/{id}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<ContactDTO> updateContact(@RequestBody ContactDTO contact
            ,  @PathVariable("id") long contactId) throws Exception {

        ContactDTO empDTO = contactImpl.update(contact, contactId);
        return ResponseEntity.ok().body(empDTO);
    }

    @DeleteMapping(value="/Contact/{id}")
    public Map<String, Boolean> deleteContact(@PathVariable long id) throws Exception{
        return contactImpl.delete(id);
    }

    @GetMapping(value="/contact/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<ContactDTO> findById(@PathVariable long id) throws Exception {

        ContactDTO contactDTO = contactImpl.getById(id);
        return ResponseEntity.ok().body(contactDTO);
    }

    @GetMapping(value="/contact")
    public ResponseEntity<List<ContactDTO>> listAll()
    {
        List<ContactDTO> contactDTO = contactImpl.getAll();
        return ResponseEntity.ok().body(contactDTO);
    }

    @PostMapping(value="/contact/check")
    public ResponseEntity<Map<String, Boolean>> isExists(@RequestBody ContactDTO contactDTO){
        Map<String, Boolean> res = new HashMap<>();
        if(contactImpl.isExists(contactDTO)) {
            res.put("available", Boolean.TRUE);
        }else {
            res.put("available", Boolean.FALSE);
        }

        return ResponseEntity.ok().body(res);
    }

}


