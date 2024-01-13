package com.rs.hospital.service;

import com.rs.hospital.dto.CustomerDTO;
import com.rs.hospital.model.Customer;
import com.rs.hospital.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;



@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repo;

    /**
     *
     * @param customerDTO
     * @return
     *
     * Steps
     * 1	Convert DTO to model
     * 2	make all opertions = > CRUD
     * 3	convert model to dto
     */
    /*
     * Convert Customer DTO class to Customer Model Class
     */
    private Customer convertDTOtoModel(CustomerDTO customerDTO) {

        Customer customer = new Customer();

        customer.setId(customerDTO.getId());
        customer.setAddress(customerDTO.getAddress());
        customer.setCity(customerDTO.getCity());
        customer.setDeliveryAddress(customerDTO.getDeliveryAddress());
        customer.setEmail(customerDTO.getEmail());
        customer.setFullName(customerDTO.getFullName());
        customer.setMobileNo(customerDTO.getMobileNo());
        customer.setPincode(customerDTO.getPinCode());
        customer.setState(customerDTO.getState());
        customer.setTitle(customerDTO.getTitle());

        return customer;
    }

    /*
     * Convert Model To DTO
     */
    private CustomerDTO convertModelToDTO(Customer customer) {
        return new CustomerDTO(customer);
    }

    @Override
    public CustomerDTO save(CustomerDTO CustomerDTO) {
        Customer customer = convertDTOtoModel(CustomerDTO); // convert dto to model for database interaction

        return convertModelToDTO(repo.save(customer)); // return DTO
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO, long bid) throws Exception {

        CustomerDTO copyCustomer = getById(bid);

        copyCustomer.setId(customerDTO.getId());
        copyCustomer.setAddress(customerDTO.getAddress());
        copyCustomer.setCity(customerDTO.getCity());
        copyCustomer.setDeliveryAddress(customerDTO.getDeliveryAddress());
        copyCustomer.setEmail(customerDTO.getEmail());
        copyCustomer.setFullName(customerDTO.getFullName());
        copyCustomer.setMobileNo(customerDTO.getMobileNo());
        copyCustomer.setPinCode(customerDTO.getPinCode());
        copyCustomer.setState(customerDTO.getState());
        copyCustomer.setTitle(customerDTO.getTitle());


        // step 1 
        Customer Customer = convertDTOtoModel(copyCustomer);

        //step 2

        // step 3
        return convertModelToDTO(repo.save(Customer));
    }

    @Override
    public CustomerDTO getById(long bid) throws Exception {
        Customer customer = repo.findById(bid)
                .orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + bid));
        return convertModelToDTO(customer);
    }

    @Override
    public CustomerDTO profileByUserId(long userId) {
        Customer customer = repo.profileByUserId(userId);
        return convertModelToDTO(customer);
    }


    @Override
    public List<CustomerDTO> getAll() {
        List<Customer> customerList = repo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for(Customer Customer : customerList) {
            customerDTOList.add(convertModelToDTO(Customer));
        }

        return customerDTOList;
    }

    @Override
    public Map<String, Boolean> delete(long bid) throws Exception {
        Customer customer = convertDTOtoModel(getById(bid));
        repo.delete(customer);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Delete", Boolean.TRUE);

        return response;

    }

    @Override
    public boolean isExists(CustomerDTO empDto) {
        Customer emp = repo.existsCustomerByEmail(empDto.getEmail());
        if(emp != null) {
            return true;
        }else {
            return false;
        }
    }


}
