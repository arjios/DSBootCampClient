package com.devsuperior.dsclient.resources.exceptions;

import java.time.Instant;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.dsclient.services.exceptions.DatabaseException;
import com.devsuperior.dsclient.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	private ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException rnfe, HttpServletRequest hsr) {
		
		StandardError se = new StandardError();
		
		se.setTimestamp(Instant.now());
		se.setStatus(HttpStatus.NOT_FOUND.value());
		se.setError("Error: Resource not found");
		se.setMessage(enfe.getMessage());
		se.setPath(hsr.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
	}
	
	@ExceptionHandler(DatabaseException.class)
	private ResponseEntity<StandardError> database(DatabaseException de, HttpServletRequest hsr) {
		
		StandardError se = new StandardError();
		
		se.setTimestamp(Instant.now());
		se.setStatus(HttpStatus.BAD_REQUEST.value());
		se.setError("Error: Database exception");
		se.setMessage(de.getMessage());
		se.setPath(hsr.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
	}

	
}
