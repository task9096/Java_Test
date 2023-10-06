package com.rs.hospital.service;


import com.rs.hospital.helper.ExcelHelper;
import com.rs.hospital.model.Customer;
import com.rs.hospital.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    CustomerRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Customer> tutorials = ExcelHelper.excelToNewCustomer(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
}
