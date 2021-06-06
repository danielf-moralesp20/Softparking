package dfm.softparking.business;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Properties;

import dfm.softparking.business.runtime.Collector;
import dfm.softparking.business.runtime.Collector.CollectorKey;
import lombok.Getter;

public class AppDocumentProperties {
	private enum EDocumentProperties {
		LANGUAGE_CODE
	}
	
	private static AppDocumentProperties singlenton;
	@Getter private File file;
	private Properties properties;
	
	private AppDocumentProperties() {
		properties = new Properties();
		file = new File((String) Collector.getCollector().get(CollectorKey.APPLICATION_PATH), "config");
	    
		file.getParentFile().mkdirs();
		try {
    		if(file.exists()) load();
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
	}
	
	synchronized public static AppDocumentProperties getInstance() {
		if(Optional.ofNullable(singlenton).isEmpty()) singlenton = new AppDocumentProperties();
		
		return singlenton;
	}
	
	public void store() throws IOException {
		FileWriter writer = new FileWriter(file);
		properties.store(writer, "Softparking file");
		writer.close();
	}
	
	public void load() throws IOException {
		FileReader reader = new FileReader(file);
		properties.load(reader);
		reader.close();
	}
	
	@SuppressWarnings("unchecked")
	public void setLanguageCode(String languageCode) {
		List<String> availableLanguages = (List<String>) Collector.getCollector().get(CollectorKey.AVAILABE_LANGUAGES);
		
		if(availableLanguages.contains(languageCode))
			set(EDocumentProperties.LANGUAGE_CODE, languageCode);
	}
	
	@SuppressWarnings("unchecked")
	public String getLanguageCode() {
		List<String> availableLanguages = (List<String>) Collector.getCollector().get(CollectorKey.AVAILABE_LANGUAGES);

		String result = get(EDocumentProperties.LANGUAGE_CODE);
		
		if(Optional.ofNullable(result).isEmpty() || !availableLanguages.contains(result)) {
			String languageCode = availableLanguages.stream().filter((val) -> val.equals(Locale.getDefault().getLanguage()))
					.findFirst().orElse(availableLanguages.get(0));
			setLanguageCode(languageCode);
			result = languageCode;
		}
		
		return result;
	}
	
	private void set(EDocumentProperties key, String value) {
		properties.setProperty(key.toString(), value);
	}
	
	private String get(EDocumentProperties key) {
		return properties.getProperty(key.toString());
	}
}
