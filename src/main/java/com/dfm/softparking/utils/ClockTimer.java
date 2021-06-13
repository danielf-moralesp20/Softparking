package com.dfm.softparking.utils;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ClockTimer implements Runnable {
	private transient PropertyChangeSupport changeListeners;
	private final long period = 1;
	private final TimeUnit timeUnit = TimeUnit.SECONDS;
	
	private ScheduledExecutorService scheduledExcServ;
	private ScheduledFuture<?> scheduledFuture;
	private Date date;
	
	public ClockTimer() {
		changeListeners = new PropertyChangeSupport(this);
		scheduledExcServ = Executors.newSingleThreadScheduledExecutor();
	}
	
	@Override
	public void run() {
		Date oldValue = date;
		date = new Date();
		changeListeners.firePropertyChange(this.getClass().getSimpleName(), oldValue, date);
	}
	
	public void startClock() {
		stopClock();
		scheduledFuture = scheduledExcServ.scheduleAtFixedRate(this, 0, period, timeUnit);
	}
	
	public void stopClock() {
		if(scheduledFuture != null)
			scheduledFuture.cancel(false);
	}
	
	
	public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
    	changeListeners.addPropertyChangeListener(listener);
    }

    public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
    	changeListeners.removePropertyChangeListener(listener);
    }
}

    