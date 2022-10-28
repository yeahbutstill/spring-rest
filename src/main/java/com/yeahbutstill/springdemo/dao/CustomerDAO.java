package com.yeahbutstill.springdemo.dao;

import com.yeahbutstill.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

	List<Customer> getCustomers();

	void saveCustomer(Customer theCustomer);

	Customer getCustomer(int theId);

	void deleteCustomer(int theId);
	
}
