package com.levimartines.challengefs.handler;

import com.levimartines.challengefs.exceptions.ObjectNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
class ResourceExceptionHandler {

	@ExceptionHandler({ObjectNotFoundException.class})
	public ResponseEntity<Void> notFoundHandler() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}

