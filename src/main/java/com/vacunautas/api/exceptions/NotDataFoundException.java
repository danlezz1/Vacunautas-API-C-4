package com.vacunautas.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT)
public class NotDataFoundException extends RuntimeException{

	public NotDataFoundException() {
		super();
	}

	public NotDataFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NotDataFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotDataFoundException(String message) {
		super(message);
	}

	public NotDataFoundException(Throwable cause) {
		super(cause);
	}

}