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
	
	@ResponseStatus(HttpStatus.BAD_REQUEST) // this is for validation; add this before doing validations or else it wont work
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
	/*
	 * This piece of code is a custom exception handler in a Spring Boot application. It's designed to handle validation errors that occur when an incoming request contains invalid data.

Here's a breakdown of what it does:

Annotations
@ResponseStatus(HttpStatus.BAD_REQUEST): This annotation ensures that when this exception handler is triggered, the response status will be set to HTTP 400 Bad Request. This tells the client that their request was invalid.

@ExceptionHandler(MethodArgumentNotValidException.class): This annotation indicates that this method should handle MethodArgumentNotValidException, which is the exception thrown when a request body validation fails.

Method Explanation
handleValidationExceptions(MethodArgumentNotValidException ex):

This method takes a MethodArgumentNotValidException as a parameter. This exception contains information about the validation errors.

It creates a Map<String, String> to store error messages, where the key is the field name that caused the validation error, and the value is the error message.

Inside the Method
ex.getBindingResult().getAllErrors().forEach((error) -> {...}):

This iterates over all validation errors.

String fieldName = ((FieldError) error).getField():

Retrieves the name of the field that caused the validation error.

String errorMessage = error.getDefaultMessage():

Retrieves the default error message for the validation error.

errors.put(fieldName, errorMessage):

Adds the field name and error message to the errors map.

return errors:

Returns the map of field names and error messages to the client as the response body.
	 */
	
}
