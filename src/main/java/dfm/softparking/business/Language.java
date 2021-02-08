package dfm.softparking.business;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dfm.softparking.business.runtime.Collector;

public abstract class Language {
	private Language() {
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
