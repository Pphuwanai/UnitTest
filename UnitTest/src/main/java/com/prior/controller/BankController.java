package com.prior.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prior.base.APIResponse;
import com.prior.bean.DataRequest;
import com.prior.entity.CustomerEntity;
import com.prior.services.BankServices;

@RestController
@RequestMapping("/bank")
public class BankController {
	
	 @Autowired 
	 public BankServices bankServices;
	 
	 @RequestMapping("/findAccountSender")
	 public APIResponse<CustomerEntity> getAccountSender(@RequestBody DataRequest request){
		 CustomerEntity result = bankServices.findByAccountNumber(request.getAccountSender());
		 return APIResponse.success(result);
	 }

	  @PostMapping("/transfer") 
	  public APIResponse<?> transferMoney(@RequestBody DataRequest request){
		  CustomerEntity customerReciever = bankServices.findByAccountNumber(request.getAccountReciever());
		  
		  CustomerEntity customerSender = bankServices.findByAccountNumber(request.getAccountSender());
		  if(customerReciever!=null && customerSender!=null) {
			  if(customerSender.getAmountMoney() >= request.getAmountMoney()) {
				  customerSender.setAmountMoney(customerSender.getAmountMoney() - request.getAmountMoney());
				  customerReciever.setAmountMoney(customerReciever.getAmountMoney() + request.getAmountMoney());
				  
				  customerSender = bankServices.updateCustomer(customerSender);
				  customerReciever = bankServices.updateCustomer(customerReciever);
			  }else {
				  return APIResponse.fail("Customer Sender not enough money.");
			  }
		  }else {
			  return APIResponse.fail("Customer not found.");
		  }
		  
		  return APIResponse.success(customerSender); 
	  }
	  
}
