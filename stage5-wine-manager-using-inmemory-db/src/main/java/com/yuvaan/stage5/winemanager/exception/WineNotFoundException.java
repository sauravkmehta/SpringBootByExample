package com.yuvaan.stage5.winemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class WineNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1649006493249057554L;

	public WineNotFoundException() {
		super();
	}

	public WineNotFoundException(final String message) {
		super(message);
	}
}
