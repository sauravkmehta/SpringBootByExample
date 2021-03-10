package com.yuvaan.stage5.winemanager.controller;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.yuvaan.stage5.winemanager.exception.NoWineDataException;
import com.yuvaan.stage5.winemanager.exception.WineNotFoundException;

@RestControllerAdvice
public class WineControllerAdvisor {
	
	@ExceptionHandler(WineNotFoundException.class)
	public ResponseEntity<Object> handleCityNotFoundException(final WineNotFoundException unfExc,
			final WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", unfExc.getMessage());

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoWineDataException.class)
	public ResponseEntity<Object> handleNodataFoundException(final NoWineDataException nudfExc,
			final WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", nudfExc.getMessage());

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}


}
