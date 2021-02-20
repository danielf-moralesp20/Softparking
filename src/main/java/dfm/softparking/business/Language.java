package dfm.softparking.business;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dfm.softparking.business.runtime.Collector;
import lombok.Getter;

public class Language {
	@Getter private String identifier;
	@Getter private String name;
	
	public Language(String identifier, String name) {
		this.identifier = identifier;
	    this.name = name;	    
	}
	
	public static String translate(String text) {
		Pattern pattern = Pattern.compile("%(.+)%");
		Matcher matcher = pattern.matcher(text);
		
		if(matcher.find()) {
			String identifier = matcher.group(1);
			ResourceBundle langBundle = (ResourceBundle) Collector.getCollector().get(Collector.BUNDLED_LANG);
			text = matcher.replaceAll(langBundle.getString(identifier));
		}
		
		return text;
	}
}
