package com.prior.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.prior.base.APIResponse;
import com.prior.bean.DataRequest;
import com.prior.entity.CustomerEntity;
import com.prior.repository.CustomerRepository;
import com.prior.services.BankServices;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class BankControllerTest {
	@Autowired
    private MockMvc mvc;
 
    @Autowired
    private CustomerRepository customerRepository;
    
    @Test
    public void transferSuccess() throws Exception {
    	DataRequest data = new DataRequest();
    	data.setAccountSender("7190542388");
    	data.setAccountReciever("7898885410");
    	data.setAmountMoney(5000);
    	Gson gson = new Gson();
    	String request = gson.toJson(data);
    	
    	MvcResult mvcResult = mvc.perform(post("/bank/transfer")
    		      .contentType(MediaType.APPLICATION_JSON)
    		      .content(request))
    			.andReturn();
    	
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        APIResponse<CustomerEntity> response = gson.fromJson(content, APIResponse.class);
        
        assertEquals(response.getCode(), 200);
        assertEquals(response.getMessage(), "SUCCESS");
    }
    
    @Test
    public void transferFailBecauseNotEnoughMoney() throws Exception {
    	DataRequest data = new DataRequest();
    	data.setAccountSender("7190542388");
    	data.setAccountReciever("7898885410");
    	data.setAmountMoney(9999999);
    	Gson gson = new Gson();
    	String request = gson.toJson(data);
    	
    	MvcResult mvcResult = mvc.perform(post("/bank/transfer")
    		      .contentType(MediaType.APPLICATION_JSON)
    		      .content(request))
    			.andReturn();
    	
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        APIResponse<CustomerEntity> response = gson.fromJson(content, APIResponse.class);
        
        assertEquals(response.getCode(), 400);
        assertEquals(response.getMessage(), "Customer Sender not enough money.");
    }
    
    @Test
    public void transferFailBecauseCustomerNotFound() throws Exception {
    	DataRequest data = new DataRequest();
    	data.setAccountSender("7190542388");
    	data.setAccountReciever("7898000000");
    	data.setAmountMoney(5000);
    	Gson gson = new Gson();
    	String request = gson.toJson(data);
    	
    	MvcResult mvcResult = mvc.perform(post("/bank/transfer")
    		      .contentType(MediaType.APPLICATION_JSON)
    		      .content(request))
    			.andReturn();
    	
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        APIResponse<CustomerEntity> response = gson.fromJson(content, APIResponse.class);
        
        assertEquals(response.getCode(), 400);
        assertEquals(response.getMessage(), "Customer not found.");
    }
    
   
}
