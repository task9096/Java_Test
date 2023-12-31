package com.rs.hospital.service;

import com.rs.hospital.dto.LeadUpfrontInvoiceDTO;

import java.util.List;
import java.util.Map;

public interface LeadUpfrontInvoiceService {
    public LeadUpfrontInvoiceDTO save(LeadUpfrontInvoiceDTO leadUpfrontInvoice);
    public LeadUpfrontInvoiceDTO update(LeadUpfrontInvoiceDTO leadUpfrontInvoice, long bid) throws Exception;
    public LeadUpfrontInvoiceDTO getById(long bid) throws Exception;
    public List<LeadUpfrontInvoiceDTO> getAll();
    public List<LeadUpfrontInvoiceDTO> getAllByInvoiceId(long invoiceId);
    public Map<String, Boolean> delete(long bid) throws Exception;
    public boolean isExists(LeadUpfrontInvoiceDTO leadUpfrontInvoiceDto);

}
