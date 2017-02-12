package com.iqmsoft.boot.spark.controller;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iqmsoft.boot.spark.config.Spark;
import com.iqmsoft.boot.spark.entity.CustomerEntity;
import com.iqmsoft.boot.spark.service.CustomerService;
import com.iqmsoft.boot.spark.service.ManyCustomersService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerSparkController implements Spark {

    private static Logger LOGGER = LoggerFactory.getLogger(CustomerSparkController.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ManyCustomersService manyCustomersService;

    @Override
    public void register() {
        get("/customer/:customerName", (request, response) -> {
            final String name = request.params(":customerName");
            final List<CustomerEntity> customerEntities = customerService.findByName(name);
            response.type("application/json");
            return new ObjectMapper().writeValueAsString(customerEntities);
        });
        post("/customer/", (request, response) -> {
            final CustomerEntity customerEntity = new ObjectMapper().readValue(request.body(), CustomerEntity.class);
            customerService.createCustomer(customerEntity);
            return "";
        });
        post("/customers/", (request, response) -> {
            try {
                final List<CustomerEntity> customerEntity = new ObjectMapper()
                        .readValue(request.body(), new TypeReference<List<CustomerEntity>>() {
                        });
                manyCustomersService.createCustomers(customerEntity);
                return "";
            }catch (Exception e){
                return e.getMessage();
            }
        });
        get("/hello", (request, response) -> {
            LOGGER.info("msg=hello");
            return "Hello World from controller!!!";
        });
    }

}