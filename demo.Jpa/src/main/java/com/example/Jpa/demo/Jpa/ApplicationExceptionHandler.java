package com.example.Jpa.demo.Jpa;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(ResourceException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, String> handleBusinessException(ResourceException ex){
	
		Map<String, String> errormap= new HashMap<>();
		errormap.put("errorMessage", ex.getMessage());
		return errormap;
	}
}
