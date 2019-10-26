package com.prior.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.prior.entity.CustomerEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	public void testFindCustomerByAcctNo() {		
		CustomerEntity c = customerRepository.findByAccountNumber("7190542388");
		
		assertThat(c.getName()).isEqualTo("Wick");
	}
}
