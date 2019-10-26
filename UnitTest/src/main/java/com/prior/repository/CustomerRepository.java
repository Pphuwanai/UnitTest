package com.prior.repository;

import org.springframework.stereotype.Repository;

import com.prior.base.BaseRepository;
import com.prior.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends BaseRepository<CustomerEntity, Integer> {

	CustomerEntity findByAccountNumber(String accountNumber);

}
