package com.iqmsoft.boot.spark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iqmsoft.boot.spark.entity.CustomerEntity;


@Service
public class ManyCustomersService {

    @Autowired
    private CustomerService customerService;

    @Transactional
    public void createCustomers(List<CustomerEntity> customerEntities){
        for(CustomerEntity customerEntity: customerEntities){
            customerService.createCustomer(customerEntity);
        }
    }
}
