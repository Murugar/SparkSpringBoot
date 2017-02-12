package com.iqmsoft.boot.spark.dao;

import java.util.List;

import com.iqmsoft.boot.spark.entity.CustomerEntity;


public interface CustomerDAO {

	List<CustomerEntity> findByName(String name);
	void create(CustomerEntity customerEntity);
	void update(CustomerEntity customerEntity);
}
