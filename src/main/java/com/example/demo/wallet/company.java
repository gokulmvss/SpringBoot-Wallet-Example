package com.example.demo.wallet;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String city;
	
//	@OneToMany(mappedBy="id")
//	private Collection<Wallet> wallets;
	
	@OneToMany(mappedBy="company")
	private Collection<Wallet> wallets = new ArrayList<>();

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(Integer id, String name, String city, Collection<Wallet> wallets) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.wallets = wallets;
	}

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Collection<Wallet> getWallets() {
		return wallets;
	}

	public void setWallets(Collection<Wallet> wallets) {
		this.wallets = wallets;
	}
	
	
}
