package com.example.demo.wallet;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String type;
	private String message;
	private LocalDateTime dateTimeofTransaction;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(String type, String message, LocalDateTime dateTimeofTransaction) {
		super();
		this.type = type;
		this.message = message;
		this.dateTimeofTransaction = dateTimeofTransaction;
	}
	public Transaction(Integer id, String type, String message, LocalDateTime dateTimeofTransaction) {
		super();
		this.id = id;
		this.type = type;
		this.message = message;
		this.dateTimeofTransaction = dateTimeofTransaction;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDateTimeofTransaction() {
		return dateTimeofTransaction;
	}
	public void setDateTimeofTransaction(LocalDateTime dateTimeofTransaction) {
		this.dateTimeofTransaction = dateTimeofTransaction;
	}
	
	
	
}
