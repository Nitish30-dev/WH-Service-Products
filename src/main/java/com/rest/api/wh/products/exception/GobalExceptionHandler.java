package com.rest.api.wh.products.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GobalExceptionHandler {

	public ResponseEntity<?> handleCustomValidationException(MethodArgumentNotValidException ex){
		ErrorDTO error= new ErrorDTO(new Date(), ex.getBindingResult().getFieldError().getDefaultMessage(), "Validation Error");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
		ErrorDTO error = new ErrorDTO(new Date(), request.getDescription(false), ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request){
		ErrorDTO error = new ErrorDTO(new Date(), request.getDescription(false), ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
	
}
