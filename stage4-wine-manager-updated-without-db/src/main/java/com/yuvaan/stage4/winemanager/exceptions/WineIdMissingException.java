package com.yuvaan.stage4.winemanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class WineIdMissingException extends RuntimeException {
	private static final long serialVersionUID = 1729465135853630284L;

	public WineIdMissingException() {
		super();
	}

	public WineIdMissingException(final String message) {
		super(message);
	}
}
