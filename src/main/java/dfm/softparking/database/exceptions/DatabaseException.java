package dfm.softparking.database.exceptions;

import lombok.Getter;

public class DatabaseException extends Exception {
	private static final long serialVersionUID = -8431814867810894284L;
	@Getter private ErrorCodes errorCode;

	public DatabaseException(ErrorCodes errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}
}
