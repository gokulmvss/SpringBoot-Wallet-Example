package com.example.demo.wallet;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class userLoginDTO {
	@NotBlank(message = "Email cannot be blank")
	private String emailInput;
	@NotBlank(message = "Password cannot be blank")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$", 
    message = "Password must be between 8 and 20 characters and contain at least one uppercase letter, one lowercase letter, one digit, and one special character")
	private String passwordInput;
	public String getEmailInput() {
		return emailInput;
	}
	public void setEmailInput(String emailInput) {
		this.emailInput = emailInput;
	}
	public String getPasswordInput() {
		return passwordInput;
	}
	public void setPasswordInput(String passwordInput) {
		this.passwordInput = passwordInput;
	}
	public userLoginDTO(@NotBlank(message = "Email cannot be blank") String emailInput,
			@NotBlank(message = "Password cannot be blank") @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$", message = "Password must be between 8 and 20 characters and contain at least one uppercase letter, one lowercase letter, one digit, and one special character") String passwordInput) {
		super();
		this.emailInput = emailInput;
		this.passwordInput = passwordInput;
	}
	public userLoginDTO() {
		super();
	}
	
	
	
	
	
}
