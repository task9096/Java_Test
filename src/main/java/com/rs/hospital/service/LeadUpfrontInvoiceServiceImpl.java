package com.rs.hospital.service;

import com.rs.hospital.dto.LeadUpfrontInvoiceDTO;
import com.rs.hospital.model.Invoice;
import com.rs.hospital.model.LeadUpfrontInvoice;
import com.rs.hospital.repository.InvoiceRepository;
import com.rs.hospital.repository.LeadUpfrontInvoiceRepository;
import com.rs.hospital.utility.PoNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class LeadUpfrontInvoiceServiceImpl implements LeadUpfrontInvoiceService {

    @Autowired
    private LeadUpfrontInvoiceRepository repo;

    @Autowired
    private InvoiceRepository invoiceRepository;

    /**
     *
     * @param leadUpfrontInvoiceDTO
     * @return
     *
     * Steps
     * 1	Convert DTO to model
     * 2	make all opertions = > CRUD
     * 3	convert model to dto
     */
    /*
     * Convert LeadUpfrontInvoice DTO class to LeadUpfrontInvoice Model Class
     */
    private LeadUpfrontInvoice convertDTOtoModel(LeadUpfrontInvoiceDTO leadUpfrontInvoiceDTO) {

        LeadUpfrontInvoice leadUpfrontInvoice = new LeadUpfrontInvoice();

        leadUpfrontInvoice.setId(leadUpfrontInvoiceDTO.getId());
        leadUpfrontInvoice.setDueAmount(leadUpfrontInvoiceDTO.getDueAmount());
        leadUpfrontInvoice.setInvoiceDate(leadUpfrontInvoiceDTO.getInvoiceDate());
        leadUpfrontInvoice.setInvoiceId(leadUpfrontInvoiceDTO.getInvoiceId());
        leadUpfrontInvoice.setPaidAmount(leadUpfrontInvoiceDTO.getPaidAmount());
        leadUpfrontInvoice.setPaidDate(leadUpfrontInvoiceDTO.getPaidDate());
        leadUpfrontInvoice.setUpFrontInvoiceNumber(leadUpfrontInvoiceDTO.getUpFrontInvoiceNumber());

        return leadUpfrontInvoice;
    }

    /*
     * Convert Model To DTO
     */
    private LeadUpfrontInvoiceDTO convertModelToDTO(LeadUpfrontInvoice leadUpfrontInvoice) {
        return new LeadUpfrontInvoiceDTO(leadUpfrontInvoice);
    }

    @Override
    public LeadUpfrontInvoiceDTO save(LeadUpfrontInvoiceDTO LeadUpfrontInvoiceDTO) {
        LeadUpfrontInvoice leadUpfrontInvoice = convertDTOtoModel(LeadUpfrontInvoiceDTO); // convert dto to model for database interaction
        leadUpfrontInvoice.setUpFrontInvoiceNumber(new PoNumberGenerator().generateUpFrontInvoiceNumber());
        Invoice invoice = invoiceRepository.findById(LeadUpfrontInvoiceDTO.getInvoiceId()).get();
        invoice.setTotalPaidAmount(invoice.getTotalPaidAmount().add(LeadUpfrontInvoiceDTO.getPaidAmount()));
        invoice.setTotalDueAmount(invoice.getTotalDueAmount().subtract(LeadUpfrontInvoiceDTO.getPaidAmount()));
        invoiceRepository.save(invoice);
        return convertModelToDTO(repo.save(leadUpfrontInvoice)); // return DTO
    }

    @Override
    public LeadUpfrontInvoiceDTO update(LeadUpfrontInvoiceDTO leadUpfrontInvoiceDTO, long bid) throws Exception {

        LeadUpfrontInvoiceDTO copyLeadUpfrontInvoice = getById(bid);

        copyLeadUpfrontInvoice.setId(leadUpfrontInvoiceDTO.getId());
        copyLeadUpfrontInvoice.setId(leadUpfrontInvoiceDTO.getId());
        copyLeadUpfrontInvoice.setDueAmount(leadUpfrontInvoiceDTO.getDueAmount());
        copyLeadUpfrontInvoice.setInvoiceDate(leadUpfrontInvoiceDTO.getInvoiceDate());
        copyLeadUpfrontInvoice.setInvoiceId(leadUpfrontInvoiceDTO.getInvoiceId());
        copyLeadUpfrontInvoice.setPaidAmount(leadUpfrontInvoiceDTO.getPaidAmount());
        copyLeadUpfrontInvoice.setPaidDate(leadUpfrontInvoiceDTO.getPaidDate());
        copyLeadUpfrontInvoice.setUpFrontInvoiceNumber(leadUpfrontInvoiceDTO.getUpFrontInvoiceNumber());


        // step 1 
        LeadUpfrontInvoice LeadUpfrontInvoice = convertDTOtoModel(copyLeadUpfrontInvoice);

        //step 2

        // step 3
        return convertModelToDTO(repo.save(LeadUpfrontInvoice));
    }

    @Override
    public LeadUpfrontInvoiceDTO getById(long bid) throws Exception {
        LeadUpfrontInvoice leadUpfrontInvoice = repo.findById(bid)
                .orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + bid));
        return convertModelToDTO(leadUpfrontInvoice);
    }

    @Override
    public List<LeadUpfrontInvoiceDTO> getAll() {
        List<LeadUpfrontInvoice> leadUpfrontInvoiceList = repo.findAll();
        List<LeadUpfrontInvoiceDTO> leadUpfrontInvoiceDTOList = new ArrayList<>();

        for(LeadUpfrontInvoice LeadUpfrontInvoice : leadUpfrontInvoiceList) {
            leadUpfrontInvoiceDTOList.add(convertModelToDTO(LeadUpfrontInvoice));
        }

        return leadUpfrontInvoiceDTOList;
    }

    @Override
    public List<LeadUpfrontInvoiceDTO> getAllByInvoiceId(long invoiceId){
        List<LeadUpfrontInvoice> leadUpfrontInvoiceList = repo.findByInvoiceId(invoiceId);
        List<LeadUpfrontInvoiceDTO> leadUpfrontInvoiceDTOList = new ArrayList<>();

        for(LeadUpfrontInvoice LeadUpfrontInvoice : leadUpfrontInvoiceList) {
            leadUpfrontInvoiceDTOList.add(convertModelToDTO(LeadUpfrontInvoice));
        }

        return leadUpfrontInvoiceDTOList;
    }

    @Override
    public Map<String, Boolean> delete(long bid) throws Exception {
        LeadUpfrontInvoice leadUpfrontInvoice = convertDTOtoModel(getById(bid));
        repo.delete(leadUpfrontInvoice);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Delete", Boolean.TRUE);

        return response;

    }

    @Override
    public boolean isExists(LeadUpfrontInvoiceDTO empDto) {
       /* LeadUpfrontInvoice emp = repo.existsLeadUpfrontInvoiceByEmail(empDto.getEmail());
        if(emp != null) {
            return true;
        }else {*/
            return false;
        //}
    }


}
