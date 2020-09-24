package dfm.softparking.database;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
    private EntityManagerFactory emf;
    private EntityManager em;
    private String persistenceUnitName;
    private transient PropertyChangeSupport changeListeners;

    public Connection(String persistenceUnitName) {
    	this();
    	this.persistenceUnitName = persistenceUnitName;
    }
    
    public Connection() {
    	changeListeners = new PropertyChangeSupport(this);
    }

    public EntityManager getConnection() {
        return em;
    }

    public synchronized void connect() {
        if (emf == null || ! emf.isOpen())
            emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        if (em == null || ! em.isOpen()) {
            em = emf.createEntityManager();
            changeListeners.firePropertyChange(this.getClass().getSimpleName(), false, em.isOpen());
        }
    }

    public synchronized void disconnect() {
        if (em != null && em.isOpen()) {
            em.close();
            changeListeners.firePropertyChange(this.getClass().getSimpleName(), true, em.isOpen());
        }
    }

    public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
    	changeListeners.addPropertyChangeListener(listener);
    }

    public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
    	changeListeners.removePropertyChangeListener(listener);
    }
    
    public void setPersistenceUnitName(String persistenceUnitName) {
		this.persistenceUnitName = persistenceUnitName;
	}
}
