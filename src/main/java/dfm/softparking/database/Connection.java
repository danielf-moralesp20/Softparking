package dfm.softparking.database;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
    private static Connection singleton;

    private EntityManagerFactory emf;
    private EntityManager em;
    private transient PropertyChangeSupport changes;

    private  Connection() {
        changes = new PropertyChangeSupport(this);
    }

    public static synchronized Connection getInstance() {
        if (singleton == null)
            singleton = new Connection();
        return singleton;
    }

    public EntityManager getConnection() {
        return em;
    }

    public synchronized void connect() {
        if (emf == null || ! emf.isOpen())
            emf = Persistence.createEntityManagerFactory("persistence");
        if (em == null || ! em.isOpen()) {
            em = emf.createEntityManager();
            changes.firePropertyChange("connection", false, em.isOpen());
        }
    }

    public synchronized void disconnect() {
        if (em != null && em.isOpen()) {
            em.close();
            changes.firePropertyChange("connection", true, em.isOpen());
        }
    }

    public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }

    public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
        changes.removePropertyChangeListener(listener);
    }
}
