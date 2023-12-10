package com.rs.hospital.service;

import com.rs.hospital.dto.CustomerLeadDTO;
import com.rs.hospital.model.CustomerLead;
import com.rs.hospital.model.LeadProduct;
import com.rs.hospital.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;



@Service
@Transactional
public class CustomerLeadServiceImpl implements CustomerLeadService {

    @Autowired
    private CustomerLeadRepository repo;

    @Autowired
    private LeadProductRepository leadProductRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductModelRepository productModelRepository;

    /**
     *
     * @param customerLeadDTO
     * @return
     *
     * Steps
     * 1	Convert DTO to model
     * 2	make all opertions = > CRUD
     * 3	convert model to dto
     */
    /*
     * Convert CustomerLead DTO class to CustomerLead Model Class
     */
    private CustomerLead convertDTOtoModel(CustomerLeadDTO customerLeadDTO) {

        CustomerLead customerLead = new CustomerLead();

        customerLead.setId(customerLeadDTO.getId());
        customerLead.setCategoryId(customerLeadDTO.getCategoryId());
        customerLead.setCustomerId(customerLeadDTO.getCustomerId());
        customerLead.setDealerId(customerLeadDTO.getDealerId());
        customerLead.setNote(customerLeadDTO.getNote());
        customerLead.setRemark(customerLeadDTO.getRemark());
        customerLead.setSource(customerLeadDTO.getSource());
        customerLead.setStatusId(customerLeadDTO.getStatusId());
        customerLead.setStatusName(customerLeadDTO.getStatusName());

        return customerLead;
    }

    /*
     * Convert CustomerLead DTO class to LeadProduct Model Class
     */
    private LeadProduct convertDTOtoModelLeadProduct(CustomerLeadDTO customerLeadDTO,LeadProduct leadProduct) {



        leadProduct.setProductId(customerLeadDTO.getProductId());
        leadProduct.setAmount(customerLeadDTO.getAmount());
        leadProduct.setLeadId(customerLeadDTO.getId());
        leadProduct.setModelId(customerLeadDTO.getModelId());
        leadProduct.setPrice(customerLeadDTO.getPrice());
        leadProduct.setQuantity(customerLeadDTO.getQuantity());

        return leadProduct;
    }

    /*
     * Convert Model To DTO
     */
    private CustomerLeadDTO convertModelToDTO(CustomerLead customerLead,LeadProduct leadProduct) {
        return new CustomerLeadDTO(customerLead,leadProduct);
    }

    @Override
    public CustomerLeadDTO save(CustomerLeadDTO customerLeadDTO) {
        CustomerLead customerLead = convertDTOtoModel(customerLeadDTO); // convert dto to model for database interaction

        customerLead = repo.save(customerLead);
        customerLeadDTO.setId(customerLead.getId());
        LeadProduct leadProduct = new LeadProduct();
        leadProduct = convertDTOtoModelLeadProduct(customerLeadDTO,leadProduct);
        leadProduct = leadProductRepository.save(leadProduct);
        return convertModelToDTO(customerLead,leadProduct); // return DTO
    }

    @Override
    public CustomerLeadDTO update(CustomerLeadDTO customerLeadDTO, long bid) throws Exception {

        CustomerLeadDTO copyCustomerLead = getById(bid);

        copyCustomerLead.setId(customerLeadDTO.getId());
        copyCustomerLead.setCategoryId(customerLeadDTO.getCategoryId());
        copyCustomerLead.setCustomerId(customerLeadDTO.getCustomerId());
        copyCustomerLead.setDealerId(customerLeadDTO.getDealerId());
        copyCustomerLead.setNote(customerLeadDTO.getNote());
        copyCustomerLead.setRemark(customerLeadDTO.getRemark());
        copyCustomerLead.setSource(customerLeadDTO.getSource());
        copyCustomerLead.setStatusId(customerLeadDTO.getStatusId());
        copyCustomerLead.setStatusName(customerLeadDTO.getStatusName());


        // step 1 
        CustomerLead customerLead = convertDTOtoModel(copyCustomerLead);
        customerLead = repo.save(customerLead);

        LeadProduct leadProduct = leadProductRepository.findByLeadId(customerLead.getId());
        leadProduct = convertDTOtoModelLeadProduct(customerLeadDTO,leadProduct);
        leadProduct = leadProductRepository.save(leadProduct);
        return convertModelToDTO(customerLead,leadProduct);
    }

    @Override
    public CustomerLeadDTO getById(long bid) throws Exception {
        CustomerLead customerLead = repo.findById(bid)
                .orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + bid));
        LeadProduct leadProduct = leadProductRepository.findByLeadId(customerLead.getId());
        return convertModelToDTO(customerLead,leadProduct);
    }

    @Override
    public List<CustomerLeadDTO> getAll() {
        List<CustomerLead> customerLeadList = repo.findAll();
        List<CustomerLeadDTO> customerLeadDTOList = new ArrayList<>();

        for(CustomerLead customerLead : customerLeadList) {
            LeadProduct leadProduct = leadProductRepository.findByLeadId(customerLead.getId());
            CustomerLeadDTO customerLeadDTO = convertModelToDTO(customerLead,leadProduct);
            customerLeadDTO.setCategoryName(categoryRepository.getOne(customerLead.getCategoryId()).getCategoryName());
            customerLeadDTO.setProductName(productRepository.getOne(leadProduct.getProductId()).getProductName());
            customerLeadDTO.setModelName(productModelRepository.getOne(leadProduct.getModelId()).getModelName());
            customerLeadDTOList.add(customerLeadDTO);
        }

        return customerLeadDTOList;
    }

    @Override
    public Map<String, Boolean> delete(long bid) throws Exception {
        CustomerLead customerLead = convertDTOtoModel(getById(bid));
        repo.delete(customerLead);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Delete", Boolean.TRUE);

        return response;

    }

    @Override
    public boolean isExists(CustomerLeadDTO empDto) {
        CustomerLead emp = repo.existsCustomerLeadByCustomerId(empDto.getCustomerId());
        if(emp != null) {
            return true;
        }else {
            return false;
        }
    }


}
