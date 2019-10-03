package com.prior.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prior.base.APIResponse;
import com.prior.bean.Customer;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bank")
public class BankController {

	@GetMapping("/test")
	public APIResponse<Customer> test(){
		return APIResponse.success(new Customer("Joe"));
	}
}
