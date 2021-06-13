package com.dfm.softparking.database.utils;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dfm.softparking.database.exceptions.DatabaseException;
import com.dfm.softparking.database.exceptions.ErrorCodes;

import lombok.Getter;
import lombok.Setter;

public class Connection {
	@Setter private String persistenceUnitName;
    private EntityManagerFactory emf;
    @Getter private EntityManager entityManager;
    private static Connection singlenton;
    
    private Connection(String persistenceUnitName) {
    	this.persistenceUnitName = persistenceUnitName;
    }
    
    public static void initialize(String persistenceUnitName) {
    	singlenton = Optional.ofNullable(singlenton).orElse(new Connection(persistenceUnitName));
    }
    
    public static Connection getInstance() {
    	return singlenton;
    }

    public synchronized void connect() throws DatabaseException {
    	try {
    		if (Optional.ofNullable(emf).isEmpty() || ! emf.isOpen()) 
    			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
            if (Optional.ofNullable(entityManager).isEmpty() || ! entityManager.isOpen()) 
                entityManager = emf.createEntityManager();
		} catch (Exception e) {
			throw new DatabaseException(ErrorCodes.DATABASE_CONNECTION_FAIL);
		}
    }

    public synchronized void disconnect() {
        if (Optional.ofNullable(entityManager).isPresent() && entityManager.isOpen())
            entityManager.close();
    }
}
