package com.dfm.softparking;

import javafx.application.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.dfm.softparking.business.AppDocumentProperties;
import com.dfm.softparking.business.runtime.Collector;
import com.dfm.softparking.business.runtime.Collector.CollectorKey;
import com.dfm.softparking.database.exceptions.DatabaseException;
import com.dfm.softparking.database.utils.Connection;
import com.dfm.softparking.views.controllers.index.IndexController;

public class App {
	public static void main(String[] args) {
    	init();    	
    	Application.launch(IndexController.class, args);
    }

    private static void init() {
    	Collector collector = Collector.getCollector();
    	
    	collector.set(CollectorKey.APPLICATION_PATH, System.getProperty("user.home") + "/.softparking");
    	
    	List<String> availableLanguages = new ArrayList<String>();
    	availableLanguages.add("es");
       	collector.set(CollectorKey.AVAILABE_LANGUAGES, availableLanguages);
       	
       	Locale locale = new Locale(AppDocumentProperties.getInstance().getLanguageCode());
       	collector.set(CollectorKey.BUNDLED_LANG, ResourceBundle.getBundle("bundles.langBundle", locale));
       	
       	Connection.initialize("persistence");
       	try { Connection.getInstance().connect(); } catch (DatabaseException e) { e.printStackTrace(); }
    }
}
