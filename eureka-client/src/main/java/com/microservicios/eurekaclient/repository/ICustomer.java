package com.microservicios.eurekaclient.repository;

import com.example.eurekaclient.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICustomer extends CrudRepository<Customer, Long> {

    List<Customer> findByName(String name);
    Customer findById(long id);

}
