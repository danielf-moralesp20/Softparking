package dfm.softparking;

import javafx.application.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import dfm.softparking.business.AppProperties;
import dfm.softparking.business.AppProperties.AppPropertyKey;
import dfm.softparking.business.runtime.Collector;
import dfm.softparking.business.runtime.Collector.CollectorKey;
import dfm.softparking.controllers.index.IndexController;
import dfm.softparking.database.exceptions.DatabaseException;
import dfm.softparking.database.utils.Connection;

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
       	
       	Locale locale = new Locale(AppProperties.getAppProperties().get(AppPropertyKey.LANGUAGE));
       	collector.set(CollectorKey.BUNDLED_LANG, ResourceBundle.getBundle("bundles.langBundle", locale));
       	
       	Connection.initialize("persistence");
       	try {
			Connection.getInstance().connect();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
    }
}

