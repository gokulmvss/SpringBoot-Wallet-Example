package com.example.demo.wallet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity // to be managed by Hibernate
public class Wallet {
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	@Id // identify object 
	@GeneratedValue //Provides for the specification of generation strategies for thevalues of primary keys. 
	private Integer id;
	private String name;
	private Double balance;
	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wallet(Integer id, String name, Double balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	
	


}
