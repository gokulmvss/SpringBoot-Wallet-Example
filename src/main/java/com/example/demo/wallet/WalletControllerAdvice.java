package com.example.demo.wallet;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WalletControllerAdvice {
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST) // his annotation is used to specify the HTTP status code that should be returned when the exception is thrown. In this case, it's setting the status code to BAD_REQUEST (HTTP 400).
	@ExceptionHandler(value = WalletException.class) // This annotation is used to define a method that will handle specific exceptions. Here, it's specifying that this method should handle exceptions of type WalletException.
	public String handleWalletException(WalletException walletexception) { 
		return walletexception.getMessage(); // get message is inbuilt function of exception
//		This line returns the message associated with the WalletException. getMessage() is a built-in method of the Exception class that returns the detail message string of the exception. 
//		It provides information about what went wrong.
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}	
	
}
