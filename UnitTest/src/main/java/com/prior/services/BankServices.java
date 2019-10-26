package com.prior.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prior.entity.CustomerEntity;
import com.prior.repository.CustomerRepository;

@Service
public class BankServices {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public CustomerEntity findByAccountNumber(String accountNumber) {
		CustomerEntity customer = customerRepository.findByAccountNumber(accountNumber);
		return customer;
	}
	
	public CustomerEntity updateCustomer(CustomerEntity c) {
		return customerRepository.save(c);
	}

}
