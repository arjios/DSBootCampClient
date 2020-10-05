package com.devsuperior.dsclient.resources.exceptions;

import java.time.Instant;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	private ResponseEntity<StandardError> entityNotFound(EntityNotFoundException enfe, HttpServletRequest hsr) {
		
		StandardError se = new StandardError();
		
		se.setTimestamp(Instant.now());
		se.setStatus(HttpStatus.NOT_FOUND.value());
		se.setError("Resource not found");
		se.setMessage(enfe.getMessage());
		se.setPath(hsr.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
	}

}
