package com.vakeel.master.exception.controller;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@ComponentScan("com.vakeel.master.exception.controller")
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> validationException(MethodArgumentNotValidException ex){
		
		Map<String, Object> response = new HashMap<>();
		response.put("timestamp", LocalTime.now());
		response.put("status", HttpStatus.BAD_REQUEST);
		
		Map<String, Object> errors = ex.getBindingResult().getFieldErrors().stream()
				.collect(Collectors.toMap(e -> e.getField(), e->e.getDefaultMessage(), (m1, m2)-> m1));
		
		response.put("errors", errors);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		
	}
}
