package com.prior.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.prior.entity.CustomerEntity;
import com.prior.repository.CustomerRepository;
import com.prior.services.BankServices;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BankServicesTest {

	@TestConfiguration
	static class BankServicesTestContextConfiguration {

		@Bean
		public BankServices bankServices() {
			return new BankServices();
		}

	}

	@Autowired
	private BankServices bankServices;

	// @MockBean
	@Autowired
	private CustomerRepository customerRepository;

	
	/*@Before
	public void setUp() {
		CustomerEntity c = new CustomerEntity();
		c.setAccountNumber("7190542388");

		Mockito.when(customerRepository.findByAccountNumber(c.getAccountNumber())).thenReturn(c);
	}*/

	@Test
	public void findCustomerShouldBeFound() {
		String citizenId = "1720800125381";
		CustomerEntity c = bankServices.findByAccountNumber("7190542388");

		assertThat(c.getCitizenId()).isEqualTo(citizenId);
	}

}
