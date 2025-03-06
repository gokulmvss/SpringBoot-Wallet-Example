package com.example.demo.wallet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer doorNo;
	private String city;

	public Address() {
		super();
	}

	public Address(Integer id, Integer doorNo, String city) {
		super();
		this.id = id;
		this.doorNo = doorNo;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(Integer doorNo) {
		this.doorNo = doorNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
