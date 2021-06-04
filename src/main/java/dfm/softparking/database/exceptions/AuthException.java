package dfm.softparking.database.exceptions;

import lombok.Getter;

public class AuthException extends Exception {
	private static final long serialVersionUID = 2461549520696368035L;
	@Getter private ErrorCodes errorCode;

	public AuthException(ErrorCodes errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}
}
