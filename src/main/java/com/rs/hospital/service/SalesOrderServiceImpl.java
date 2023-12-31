package com.rs.hospital.service;

import com.rs.hospital.dto.SalesOrderDTO;
import com.rs.hospital.model.*;
import com.rs.hospital.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class SalesOrderServiceImpl implements SalesOrderService{

    @Autowired
    private CustomerLeadRepository customerLeadRepository;

    @Autowired
    private LeadProductRepository leadProductRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductModelRepository productModelRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DealerRepository dealerRepository;

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    @Override
    public String addSalesOrderByLeadId(Long leadId, Long userId){
        LeadProduct leadProduct = leadProductRepository.findByLeadId(leadId);
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setLeadId(leadId);
        salesOrder.setUserId(userId);
        Long amt = leadProduct.getAmount().multiply(BigDecimal.valueOf(leadProduct.getQuantity())).longValue();
        salesOrder.setTotalAmount(amt);
        salesOrder.setCreatedDate(LocalDate.now());
        salesOrderRepository.save(salesOrder);
        return "SAVE";
    }

    @Override
    public SalesOrderDTO getSalesOrderByLeadId(Long leadId){
        SalesOrderDTO salesOrderDTO = new SalesOrderDTO();
        CustomerLead customerLead = customerLeadRepository.findById(leadId).get();
        setCustomerLead(salesOrderDTO,customerLead);
        LeadProduct leadProduct = leadProductRepository.findByLeadId(customerLead.getId());
        setLeadProduct(salesOrderDTO,leadProduct);
        Category category = categoryRepository.findById(customerLead.getCategoryId()).get();
        setCategory(salesOrderDTO,category);
        Product product = productRepository.findById(leadProduct.getProductId()).get();
        setProduct(salesOrderDTO,product);
        ProductModel productModel = productModelRepository.findById(leadProduct.getModelId()).get();
        setProductModel(salesOrderDTO,productModel);
        Customer customer = customerRepository.findById(customerLead.getCustomerId()).get();
        setCustomer(salesOrderDTO,customer);
        //Dealer dealer = dealerRepository.findById(customerLead.getDealerId()).get();
        //setDealer(salesOrderDTO, dealer);
        //User user = userRepository.findById();
        return salesOrderDTO;
    }

    private void setDealer(SalesOrderDTO salesOrderDTO,Dealer dealer){
        salesOrderDTO.setDealerId(dealer.getId());
        salesOrderDTO.setDealerName(dealer.getFullName());
    }

    private void setCustomer(SalesOrderDTO salesOrderDTO,Customer customer){
        salesOrderDTO.setCustomerId(customer.getId());
        salesOrderDTO.setCustomerName(customer.getFullName());
    }

    private void setCustomerLead(SalesOrderDTO salesOrderDTO,CustomerLead customerLead){
        salesOrderDTO.setLeadId(customerLead.getId());
        salesOrderDTO.setRemark(customerLead.getRemark());
        salesOrderDTO.setSource(customerLead.getSource());
        salesOrderDTO.setNote(customerLead.getNote());
        salesOrderDTO.setStatusName(customerLead.getStatusName());
    }

    private void setLeadProduct(SalesOrderDTO salesOrderDTO,LeadProduct leadProduct){
        salesOrderDTO.setQuantity(leadProduct.getQuantity());
        salesOrderDTO.setAmount(leadProduct.getAmount());
        salesOrderDTO.setPrice(leadProduct.getPrice());
        salesOrderDTO.setTotalAmount(leadProduct.getAmount().multiply(BigDecimal.valueOf(leadProduct.getQuantity())));
    }

    private void setCategory(SalesOrderDTO salesOrderDTO,Category category){
        salesOrderDTO.setCategoryId(category.getId());
        salesOrderDTO.setCategoryName(category.getCategoryName());
    }

    private void setProduct(SalesOrderDTO salesOrderDTO,Product product){
        salesOrderDTO.setProductId(product.getId());
        salesOrderDTO.setProductName(product.getProductName());
    }

    private void setProductModel(SalesOrderDTO salesOrderDTO,ProductModel productModel){
        salesOrderDTO.setModelId(productModel.getId());
        salesOrderDTO.setModelName(productModel.getModelName());
        salesOrderDTO.setModelNumber(productModel.getModelNumber());
        salesOrderDTO.setImageUrl(productModel.getImageUrl());

    }


    @Override
    public List<SalesOrder> getAll() {
        List<SalesOrder> salesOrderList = salesOrderRepository.findAll();
        return salesOrderList;
    }

}
