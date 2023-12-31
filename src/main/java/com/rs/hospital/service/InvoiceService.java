package com.rs.hospital.service;

import com.rs.hospital.dto.InvoiceDTO;

import java.util.List;
import java.util.Map;

public interface InvoiceService {
    public InvoiceDTO save(InvoiceDTO invoice);
    public InvoiceDTO update(InvoiceDTO invoice, long bid) throws Exception;
    public InvoiceDTO getById(long bid) throws Exception;
    public List<InvoiceDTO> getAll();
    public Map<String, Boolean> delete(long bid) throws Exception;
    public boolean isExists(InvoiceDTO invoiceDto);

}
