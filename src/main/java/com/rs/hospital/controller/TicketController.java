package com.rs.hospital.controller;

import com.rs.hospital.dto.TicketDTO;
import com.rs.hospital.service.TicketServiceImpl;
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
public class TicketController{
    @Autowired
    private TicketServiceImpl ticketImpl;

    @PostMapping(value="/ticket",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<TicketDTO> addTicket(@RequestBody TicketDTO ticket) {

        TicketDTO ticketDTO = ticketImpl.save(ticket);
        return ResponseEntity.ok().body(ticketDTO);
    }

    @PutMapping(value="/ticket/{id}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<TicketDTO> updaTeticket(@RequestBody TicketDTO ticket
            ,  @PathVariable("id") long ticketId) throws Exception {

        TicketDTO empDTO = ticketImpl.update(ticket, ticketId);
        return ResponseEntity.ok().body(empDTO);
    }

    @DeleteMapping(value="/ticket/{id}")
    public Map<String, Boolean> deleteTicket(@PathVariable long id) throws Exception{
        return ticketImpl.delete(id);
    }

    @GetMapping(value="/ticket/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<TicketDTO> findById(@PathVariable long id) throws Exception {

        TicketDTO ticketDTO = ticketImpl.getById(id);
        return ResponseEntity.ok().body(ticketDTO);
    }

    @GetMapping(value="/ticket")
    public ResponseEntity<List<TicketDTO>> listAll()
    {
        List<TicketDTO> ticketDTO = ticketImpl.getAll();
        return ResponseEntity.ok().body(ticketDTO);
    }

    @PostMapping(value="/ticket/check")
    public ResponseEntity<Map<String, Boolean>> isExists(@RequestBody TicketDTO ticketDTO){
        Map<String, Boolean> res = new HashMap<>();
        if(ticketImpl.isExists(ticketDTO)) {
            res.put("available", Boolean.TRUE);
        }else {
            res.put("available", Boolean.FALSE);
        }

        return ResponseEntity.ok().body(res);
    }

}


