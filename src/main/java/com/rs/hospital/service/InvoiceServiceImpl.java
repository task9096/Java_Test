package com.rs.hospital.service;

import com.rs.hospital.dto.InvoiceDTO;
import com.rs.hospital.model.Invoice;
import com.rs.hospital.repository.InvoiceNativeRepository;
import com.rs.hospital.repository.InvoiceRepository;
import com.rs.hospital.utility.PoNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;



@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository repo;

    @Autowired
    private InvoiceNativeRepository invoiceNativeRepository;

    /**
     *
     * @param invoiceDTO
     * @return
     *
     * Steps
     * 1	Convert DTO to model
     * 2	make all opertions = > CRUD
     * 3	convert model to dto
     */
    /*
     * Convert Invoice DTO class to Invoice Model Class
     */
    private Invoice convertDTOtoModel(InvoiceDTO invoiceDTO) {

        Invoice invoice = new Invoice();

        invoice.setId(invoiceDTO.getId());
        invoice.setInvoiceDate(invoiceDTO.getInvoiceDate());
        invoice.setInvoiceNumber(invoiceDTO.getInvoiceNumber());
        invoice.setPurchaseOrderId(invoiceDTO.getPurchaseOrderId());
        invoice.setTotalDueAmount(invoiceDTO.getTotalDueAmount());
        invoice.setTotalPaidAmount(invoiceDTO.getTotalPaidAmount());


        return invoice;
    }

    /*
     * Convert Model To DTO
     */
    private InvoiceDTO convertModelToDTO(Invoice invoice) {
        return new InvoiceDTO(invoice);
    }

    @Override
    public InvoiceDTO save(InvoiceDTO InvoiceDTO) {
        Invoice invoice = convertDTOtoModel(InvoiceDTO); // convert dto to model for database interaction
        invoice.setInvoiceNumber(new PoNumberGenerator().generateInvoiceNumber());

        return convertModelToDTO(repo.save(invoice)); // return DTO
    }

    @Override
    public InvoiceDTO update(InvoiceDTO invoiceDTO, long bid) throws Exception {

        InvoiceDTO copyInvoice = getById(bid);

        copyInvoice.setId(invoiceDTO.getId());
        copyInvoice.setId(invoiceDTO.getId());
        copyInvoice.setInvoiceDate(invoiceDTO.getInvoiceDate());
        copyInvoice.setInvoiceNumber(invoiceDTO.getInvoiceNumber());
        copyInvoice.setPurchaseOrderId(invoiceDTO.getPurchaseOrderId());
        copyInvoice.setTotalDueAmount(invoiceDTO.getTotalDueAmount());
        copyInvoice.setTotalPaidAmount(invoiceDTO.getTotalPaidAmount());


        // step 1 
        Invoice Invoice = convertDTOtoModel(copyInvoice);

        //step 2

        // step 3
        return convertModelToDTO(repo.save(Invoice));
    }

    @Override
    public InvoiceDTO getById(long bid) throws Exception {
        Invoice invoice = repo.findById(bid)
                .orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + bid));
        return convertModelToDTO(invoice);
    }

    @Override
    public List<InvoiceDTO> getAll() {
        /*List<Invoice> invoiceList = repo.findAll();
        List<InvoiceDTO> invoiceDTOList = new ArrayList<>();

        for(Invoice Invoice : invoiceList) {
            invoiceDTOList.add(convertModelToDTO(Invoice));
        }*/
        List<InvoiceDTO> invoiceDTOList = invoiceNativeRepository.findAllInvoiceWithCustomerName();

        return invoiceDTOList;
    }

    @Override
    public Map<String, Boolean> delete(long bid) throws Exception {
        Invoice invoice = convertDTOtoModel(getById(bid));
        repo.delete(invoice);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Delete", Boolean.TRUE);

        return response;

    }

    @Override
    public boolean isExists(InvoiceDTO invoiceDTO) {
        Invoice emp = repo.existsInvoiceByInvoiceNumber(invoiceDTO.getInvoiceNumber());
        if(emp != null) {
            return true;
        }else {
            return false;
        }
    }


}
