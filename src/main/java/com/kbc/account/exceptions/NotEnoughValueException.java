
	package com.kbc.account.exceptions;

	import org.springframework.http.HttpStatus;
	import org.springframework.web.bind.annotation.ResponseStatus;

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class NotEnoughValueException extends RuntimeException {
		public NotEnoughValueException(String message) {
			super(message);
		}
	}
