package com.yuvaan.stage4.winemanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "Wine not found.")
public class WineNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public WineNotFoundException() {
		super();
	}

	public WineNotFoundException(final String message) {
		super(message);
	}
}
