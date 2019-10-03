package com.prior.bean;

import lombok.Getter;
import lombok.Setter;

public class Customer {
	@Getter
	@Setter
	private String name;

	public Customer(String name) {
		super();
		this.name = name;
	}
}
