package com.dfm.softparking.database.exceptions;

import lombok.Getter;

public enum ErrorCodes {
	DATABASE_CONNECTION_FAIL("Trying to connect to database failed."),
	INVALID_EMAIL("The email address is not valid"),
	WRONG_CREDENTIALS("The email address or password isn't correct."),
	EMAIL_ALREADY_IN_USE("There already exists an account with the given email address."),
	WEAK_PASSWORD("The password is not strong enough."),
	USER_DISABLED("The user corresponding to the given email has been disabled");
	
	@Getter private String message;
	
	private ErrorCodes(String message) {
		this.message = message;
	}
}
