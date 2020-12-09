package com.microservicios.eurekaclient.repository;

import com.microservicios.eurekaclient.model.Customer;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    private ICustomer customerRepository;
    public Customer create(Customer customer) throws Exception {
        try {
            customer.setCreationDate(new Date());
            Customer customerSaved = customerRepository.save(customer);
            return customerSaved;
        } catch(Exception e ) {
            logger.error("Exception occured Cause {} Message {} exception {}",e.getCause(), e.getMessage(), e);
            throw new Exception("The resource you were trying to reach is not found");
        }
    }

    public Customer findById(Long customerId) throws Exception {
        try {
            Optional<Customer> customerOptional = customerRepository.findById(customerId);
            if(customerOptional.isPresent())
                return customerOptional.get();
            else
                throw new Exception("The resource you were trying to reach is not found");
        } catch(Exception e ) {
            logger.error("Exception occured Cause {} Message {} exception {}",e.getCause(), e.getMessage(), e);
            throw new Exception("The resource you were trying to reach is not found");
        }
    }

    public List<Customer> findByName(String customerName) throws Exception {
        try {
            List<Customer> customerList = customerRepository.findByName(customerName);
            if(!Objects.isNull(customerList))
                return customerList;
            else
                throw new Exception("The resource you were trying to reach is not found");
        } catch(Exception e ) {
            logger.error("Exception occured Cause {} Message {} exception {}",e.getCause(), e.getMessage(), e);
            throw new Exception("The resource you were trying to reach is not found");
        }
    }

    public List<Customer> findAll() throws Exception {
        try {
            List<Customer> customerList = (List<Customer>) customerRepository.findAll();
            if(!Objects.isNull(customerList))
                return customerList;
            else
                throw new Exception("The resource you were trying to reach is not found");
        } catch(Exception e ) {
            logger.error("Exception occured Cause {} Message {} exception {}",e.getCause(), e.getMessage(), e);
            throw new Exception("The resource you were trying to reach is not found");
        }
    }

}
