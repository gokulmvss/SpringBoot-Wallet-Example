package com.example.demo.wallet;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity // to be managed by Hibernate
public class Wallet {
	
	@Id // identify object
	@GeneratedValue //Provides for the specification of generation strategies for the values of primary keys. 
	private Integer id;
	@NotNull(message = "Name cannot be null")
//	Not null is not equal to not blank
	@NotBlank(message = "Name cannot be blank")
	@Size(min = 3, max = 6, message = "Name must be between 3 and 6 charactera") // Validation annotation
	private String name;
	@Min(value = 1000, message = "Minimum balance is 1000")
	private Double balance;

	@NotBlank(message = "Email cannot be blank")
//	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email should be valid")
	@Email(message="Email should be valid")
	private String email;
	@NotBlank(message = "Password cannot be blank")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$", 
    message = "Password must be between 8 and 20 characters and contain at least one uppercase letter, one lowercase letter, one digit, and one special character")
	private String password;
	@NotBlank(message = "Confirm Password cannot be blank")
	private String confirmPassword;
	
	public Wallet(
			@NotNull(message = "Name cannot be null") @NotBlank(message = "Name cannot be blank") @Size(min = 3, max = 6, message = "Name must be between 3 and 6 charactera") String name,
			@Min(value = 1000, message = "Minimum balance is 1000") Double balance) {
		super();
		this.name = name;
		this.balance = balance;
	}

	@OneToOne // has attributes on cascasde delete to remove the entry if wallet is deleted
	private Address address;
	
	@OneToMany
	private Collection<Transaction> transactions= new ArrayList();
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="company_id")
	private Company company;

	public Wallet(Integer id,
			@NotNull(message = "Name cannot be null") @NotBlank(message = "Name cannot be blank") @Size(min = 3, max = 6, message = "Name must be between 3 and 6 charactera") String name,
			@Min(value = 1000, message = "Minimum balance is 1000") Double balance,
			@NotBlank(message = "Email cannot be blank") @Email(message = "Email should be valid") String email,
			@NotBlank(message = "Password cannot be blank") @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$", message = "Password must be between 8 and 20 characters and contain at least one uppercase letter, one lowercase letter, one digit, and one special character") String password,
			@NotBlank(message = "Confirm Password cannot be blank") String confirmPassword, Address address,
			Collection<Transaction> transactions, com.example.demo.wallet.Company company) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.address = address;
		this.transactions = transactions;
		this.company = company;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Collection<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Collection<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Wallet() {
		super();
	}

//	public Wallet(Integer id, String name, Double balance) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.balance = balance;
//		
//	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

	

}
