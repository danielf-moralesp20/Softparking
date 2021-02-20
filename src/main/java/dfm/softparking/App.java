package dfm.softparking;

import javafx.application.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import dfm.softparking.business.AppProperties;
import dfm.softparking.business.runtime.Collector;
import dfm.softparking.controllers.index.IndexController;

public class App {
    public static void main(String[] args) {
    	init();
    	Application.launch(IndexController.class, args);
    }
    
    private static void init() {
    	Collector collector = Collector.getCollector();
    	
    	collector.set(Collector.APPLICATION_PATH, System.getProperty("user.home") + "/.softparking");
    	
    	List<String> availableLanguages = new ArrayList<String>();
    	availableLanguages.add("es");
       	collector.set(Collector.AVAILABE_LANGUAGES, availableLanguages);
       	
       	Locale locale = new Locale(AppProperties.getAppProperties().get(AppProperties.LANGUAGE));
       	collector.set(Collector.BUNDLED_LANG, ResourceBundle.getBundle("bundles.langBundle", locale));
    }
}

