package dfm.softparking.business;

import java.util.ResourceBundle;

import dfm.softparking.business.runtime.Collector;
import dfm.softparking.business.runtime.Collector.CollectorKey;
import lombok.Getter;

public class Language {
	@Getter private String identifier;
	@Getter private String name;
	
	public Language(String identifier, String name) {
		this.identifier = identifier;
	    this.name = name;	    
	}
	
	public static String translate(String key) {
		ResourceBundle langBundle = (ResourceBundle) Collector.getCollector().get(CollectorKey.BUNDLED_LANG);
		return langBundle.getString(key.toUpperCase());
	}
}
