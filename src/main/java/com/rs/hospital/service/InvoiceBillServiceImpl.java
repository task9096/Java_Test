package com.rs.hospital.service;

import com.rs.hospital.dto.InvoiceBillDTO;
import com.rs.hospital.repository.InvoiceBillNativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InvoiceBillServiceImpl implements InvoiceBillService{

    @Autowired
    private InvoiceBillNativeRepository invoiceBillNativeRepository;

    @Autowired
    private LeadUpfrontInvoiceServiceImpl leadUpfrontInvoiceImpl;

    public InvoiceBillDTO getInvoiceBill(Long invoiceId){
        InvoiceBillDTO invoiceBillDTO = invoiceBillNativeRepository.getInvoiceBill(invoiceId);
        invoiceBillDTO.setListLeadUpfrontInvoiceDTO(leadUpfrontInvoiceImpl.getAllByInvoiceId(invoiceId));
        return invoiceBillDTO;
    }
}
