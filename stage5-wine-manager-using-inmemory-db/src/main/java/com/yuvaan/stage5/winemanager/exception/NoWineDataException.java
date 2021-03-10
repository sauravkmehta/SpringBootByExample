package com.yuvaan.stage5.winemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class NoWineDataException extends RuntimeException {
	private static final long serialVersionUID = 1729465135853630284L;

	public NoWineDataException() {
		super();
	}

	public NoWineDataException(final String message) {
		super(message);
	}
}
