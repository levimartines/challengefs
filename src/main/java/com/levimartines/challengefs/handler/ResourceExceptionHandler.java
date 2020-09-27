package com.levimartines.challengefs.handler;

import com.levimartines.challengefs.exceptions.ObjectNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
class ResourceExceptionHandler {

	@ExceptionHandler({ObjectNotFoundException.class})
	public ResponseEntity<Void> notFoundHandler() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@ExceptionHandler({MethodArgumentNotValidException.class,
		DataIntegrityViolationException.class})
	public ResponseEntity<Void> invalidInputHandler() {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}

