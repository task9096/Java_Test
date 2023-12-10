package com.rs.hospital.service;

import com.rs.hospital.dto.TicketDTO;
import com.rs.hospital.model.Ticket;
import com.rs.hospital.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
@Transactional
public class TicketServiceImpl  implements TicketService {

    @Autowired
    private TicketRepository repo;

    /**
     *
     * @param ticketDTO
     * @return
     *
     * Steps
     * 1	Convert DTO to model
     * 2	make all opertions = > CRUD
     * 3	convert model to dto
     */
    /*
     * Convert Ticket DTO class to Ticket Model Class
     */
    private Ticket convertDTOtoModel(TicketDTO ticketDTO) {

        Ticket ticket = new Ticket();

        ticket.setId(ticketDTO.getId());
        ticket.setBusinessName(ticketDTO.getBusinessName());
        ticket.setComments(ticketDTO.getComments());
        ticket.setContactName(ticketDTO.getContactName());
        ticket.setEmail(ticketDTO.getEmail());
        ticket.setContract(ticketDTO.getContract());
        ticket.setMobileNo(ticketDTO.getMobileNo());
        ticket.setName(ticketDTO.getName());
        ticket.setResolution(ticketDTO.getResolution());
        ticket.setSupportMode(ticketDTO.getSupportMode());
        ticket.setStatus(ticketDTO.getStatus());
        ticket.setTicketsSource(ticketDTO.getTicketsSource());
        ticket.setTicketType(ticketDTO.getTicketType());

        return ticket;
    }

    /*
     * Convert Model To DTO
     */
    private TicketDTO convertModelToDTO(Ticket ticket) {
        return new TicketDTO(ticket);
    }

    @Override
    public TicketDTO save(TicketDTO ticketDTO) {
        Ticket ticket = convertDTOtoModel(ticketDTO); // convert dto to model for database interaction

        return convertModelToDTO(repo.save(ticket)); // return DTO
    }

    @Override
    public TicketDTO update(TicketDTO ticketDTO, long bid) throws Exception {

        TicketDTO copyTicket = getById(bid);

        copyTicket.setId(ticketDTO.getId());
        copyTicket.setBusinessName(ticketDTO.getBusinessName());
        copyTicket.setComments(ticketDTO.getComments());
        copyTicket.setContactName(ticketDTO.getContactName());
        copyTicket.setEmail(ticketDTO.getEmail());
        copyTicket.setContract(ticketDTO.getContract());
        copyTicket.setMobileNo(ticketDTO.getMobileNo());
        copyTicket.setName(ticketDTO.getName());
        copyTicket.setResolution(ticketDTO.getResolution());
        copyTicket.setSupportMode(ticketDTO.getSupportMode());
        copyTicket.setStatus(ticketDTO.getStatus());
        copyTicket.setTicketsSource(ticketDTO.getTicketsSource());
        copyTicket.setTicketType(ticketDTO.getTicketType());


        // step 1 
        Ticket Ticket = convertDTOtoModel(copyTicket);

        //step 2

        // step 3
        return convertModelToDTO(repo.save(Ticket));
    }

    @Override
    public TicketDTO getById(long bid) throws Exception {
        Ticket ticket = repo.findById(bid)
                .orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + bid));
        return convertModelToDTO(ticket);
    }

    @Override
    public List<TicketDTO> getAll() {
        List<Ticket> ticketList = repo.findAll();
        List<TicketDTO> ticketDTOList = new ArrayList<>();

        for(Ticket ticket : ticketList) {
            ticketDTOList.add(convertModelToDTO(ticket));
        }

        return ticketDTOList;
    }

    @Override
    public Map<String, Boolean> delete(long bid) throws Exception {
        Ticket ticket = convertDTOtoModel(getById(bid));
        repo.delete(ticket);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Delete", Boolean.TRUE);

        return response;

    }

    @Override
    public boolean isExists(TicketDTO ticketDTO) {
        Ticket ticket = repo.existsTicketByEmail(ticketDTO.getEmail());
        if(ticket != null) {
            return true;
        }else {
            return false;
        }
    }


}
