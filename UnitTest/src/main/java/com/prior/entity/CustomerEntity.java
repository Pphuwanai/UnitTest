package com.prior.entity;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class CustomerEntity {
	
	@Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = IDENTITY)
    private Integer customerId;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "account_number", length = 10)
	private String accountNumber;
	
	@Column(name = "citizen_id", length = 13)
	private String citizenId;
	 
	@Column(name = "amount_money")
	private Double amountMoney;

	public CustomerEntity(Integer customerId, String name, String accountNumber, String citizenId, Double amountMoney) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.accountNumber = accountNumber;
		this.citizenId = citizenId;
		this.amountMoney = amountMoney;
	}

	public CustomerEntity() {
		super();
	}
	
}
