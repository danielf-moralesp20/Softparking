package dfm.softparking.business;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import dfm.softparking.business.runtime.Collector;
import lombok.Getter;

public class AppProperties {
	private static AppProperties singlenton;
	@Getter private File file;
	private Properties properties;
	
	public static String LANGUAGE = "language";
	
	private AppProperties() {
		properties = new Properties();
		file = new File((String) Collector.getCollector().get(Collector.APPLICATION_PATH), "config");
	    init();
	}
	
	synchronized public static AppProperties getAppProperties() {
		if(singlenton == null) singlenton = new AppProperties();
		
		return singlenton;
	}
	
	private void init() {
    	file.getParentFile().mkdirs();
    	try {
    		if(file.exists()) load();
        	else defaultProperties();
		} catch (Exception e) { e.printStackTrace(); }
	}
	
	@SuppressWarnings("unchecked")
	private void defaultProperties() throws IOException {
		// Language 
		Locale locale = Locale.getDefault();
		List<String> availableLanguages = (List<String>) Collector.getCollector().get(Collector.AVAILABE_LANGUAGES);
		if(!availableLanguages.contains(locale.getLanguage())) 
			locale = new Locale(availableLanguages.get(0));
		properties.setProperty(LANGUAGE, locale.getLanguage());
		
		store();
	}
	
	public void store() throws IOException {
		FileWriter writer = new FileWriter(file);
		properties.store(writer, "Softparking configuration file");
		writer.close();
	}
	
	public void load() throws IOException {
		FileReader reader = new FileReader(file);
		properties.load(reader);
		reader.close();
	}
	
	public String get(String key) {
		return (String) properties.get(key);
	}
	
	public void set(String key, String value) {
		properties.setProperty(key, value);
	}
}
