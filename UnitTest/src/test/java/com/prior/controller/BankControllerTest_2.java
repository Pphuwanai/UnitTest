package com.prior.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.google.gson.Gson;
import com.prior.base.APIResponse;
import com.prior.bean.DataRequest;
import com.prior.entity.CustomerEntity;
import com.prior.repository.CustomerRepository;
import com.prior.services.BankServices;

@RunWith(SpringRunner.class)
@WebMvcTest(BankController.class)
public class BankControllerTest_2 {/*
	
	@Autowired
    private MockMvc mvc;
 
    @MockBean
    public BankServices bankService;
    
    @Before
    public void setUp() {
    	CustomerEntity c1 = new CustomerEntity(1, "Wick", "7190542388", "1720800125381", 5000000.0);
    	CustomerEntity c2 = new CustomerEntity(2, "John", "7898885410", "1720800125999", 3000.0);
		
	    Mockito.when(bankService.findByAccountNumber(c1.getAccountNumber()))
	      .thenReturn(c1);
	    
	    Mockito.when(bankService.findByAccountNumber(c2.getAccountNumber()))
	      .thenReturn(c2);
    }
    
    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray() throws Exception {
        
       /* DataRequest data = new DataRequest();
        data.setAccountSender("7190542388");
        data.setAccountReciever("7898885410");
        data.setAmountMoney(1500.0);
        
        Gson gson = new Gson();
        String request = gson.toJson(data);
     
        MvcResult mvcResult = mvc.perform(post("/bank/transfer")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(request)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        APIResponse<CustomerEntity> response = gson.fromJson(content, APIResponse.class);
        System.out.print(response.getResult());
        //{customerId=2.0, name=John, accountNumber=7898885410, citizenId=1720800125999, amountMoney=4500.0}
        assertEquals(content, "Product is created successfully");   
        */
        
		/*mvc.perform(get("/api/employees").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(3))).andExpect(jsonPath("$[0].name", is(alex.getName())))
				.andExpect(jsonPath("$[1].name", is(john.getName())))
				.andExpect(jsonPath("$[2].name", is(bob.getName())));*/
        /*mvc.perform(get("/bank/test")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk());*/
          //.andExpect(jsonPath("$", hasSize(1)))
          //.andExpect(jsonPath("$[0].name", is(alex.getName())));
    /*}*/
}
