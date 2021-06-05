package dfm.softparking.utils.forms.validators;

import com.jfoenix.validation.RegexValidator;

public class EmailValidator extends RegexValidator {
	
	public EmailValidator(String message) {
		super(message);
		init();
	}
	
	public EmailValidator() {
		init();
	}	

	private void init() {
		super.setRegexPattern("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
				+ "@(?!-)(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
	}
}
