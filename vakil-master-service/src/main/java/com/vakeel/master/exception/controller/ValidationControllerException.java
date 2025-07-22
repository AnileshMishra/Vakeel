package com.vakeel.master.exception.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vakeel.master.exception.ValidationException;

@ControllerAdvice
public class ValidationControllerException {

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Object> validationException(ValidationException ex) {
		Map<String, Object> response = new HashMap<>();
		response.put("timestamp", LocalDateTime.now());
		response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
