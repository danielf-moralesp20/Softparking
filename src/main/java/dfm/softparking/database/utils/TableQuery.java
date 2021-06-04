package dfm.softparking.database.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dfm.softparking.database.exceptions.DatabaseException;
import dfm.softparking.database.exceptions.ErrorCodes;
import lombok.NonNull;

public class TableQuery<T> {
	
	public static TableQuery<?> of(Class<?> resultCLass) {
		try {
			return (TableQuery<?>) resultCLass.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> useNamedQuery(String name, @NonNull Map<String, ?>params) throws DatabaseException {
		TypedQuery<T> tipedQuery = (TypedQuery<T>) getEntManager().createNamedQuery(name, this.getClass());
		params.forEach((k, v) -> tipedQuery.setParameter(k, v));
		
		return tipedQuery.getResultList();
	}
	
	public T useNameQuerySingleResult(String name, @NonNull Map<String, ?>params) throws DatabaseException {
		List<T> result = useNamedQuery(name, params);
		return result.isEmpty() ? null : result.get(0);
	}
	
	private EntityManager getEntManager() throws DatabaseException {
		EntityManager result = Connection.getInstance().getEntityManager();
		
		if(Optional.ofNullable(result).isEmpty())
			throw new DatabaseException(ErrorCodes.DATABASE_CONNECTION_FAIL);
		
		return result;
	}
}
