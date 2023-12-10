package com.rs.hospital.service;

import com.rs.hospital.dto.TicketDTO;

import java.util.List;
import java.util.Map;

public interface TicketService {

    public TicketDTO save(TicketDTO ticket);
    public TicketDTO update(TicketDTO ticket, long bid) throws Exception;
    public TicketDTO getById(long bid) throws Exception;
    public List<TicketDTO> getAll();
    public Map<String, Boolean> delete(long bid) throws Exception;
    public boolean isExists(TicketDTO ticketDto);

}
