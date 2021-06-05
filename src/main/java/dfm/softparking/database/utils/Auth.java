package dfm.softparking.database.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import dfm.softparking.database.entities.TOperario;
import dfm.softparking.database.exceptions.AuthException;
import dfm.softparking.database.exceptions.DatabaseException;
import dfm.softparking.database.exceptions.ErrorCodes;
import lombok.Getter;
import lombok.NonNull;

public class Auth {
	@Getter private static TOperario currentUser;
	
	public static TOperario signInWithEmailAndPassword(@NonNull String email, @NonNull String pass) throws AuthException, DatabaseException {
		Map<String, String> params = new HashMap<>();
		params.put("email", email.strip().toLowerCase());
		params.put("pass", pass.strip());
		
		TOperario result = TOperario.of().useNameQuerySingleResult("login", params);
		
		if(Optional.ofNullable(result).isEmpty())
			throw new AuthException(ErrorCodes.WRONG_CREDENTIALS);
		if(result.isDisabled())
			throw new AuthException(ErrorCodes.USER_DISABLED);
		
		currentUser = result;
		
		return result;
	}
}
