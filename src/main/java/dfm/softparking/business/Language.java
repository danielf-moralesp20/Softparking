package dfm.softparking.business;

import java.util.List;
import java.util.ResourceBundle;

import dfm.softparking.business.runtime.Collector;
import dfm.softparking.business.runtime.Collector.CollectorKey;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;
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
	
	@SuppressWarnings("unchecked")
	public static ObservableList<Language> getAvailableLanguages() {
		ObservableList<Language> languages = FXCollections.observableArrayList();
		List<String> availableLanguagesCodes = (List<String>) Collector.getCollector().get(CollectorKey.AVAILABE_LANGUAGES);
		
		availableLanguagesCodes.forEach((langCode) -> languages.add(new Language(langCode, Language.translate(langCode))));
		
		return languages;
	}
	
	public static class LanguageCombooBoxConverter extends StringConverter<Language> {
		private ComboBox<Language> comboBox;
		
		public LanguageCombooBoxConverter(ComboBox<Language> comboBox) {
			this.comboBox = comboBox;
		}
		
		public LanguageCombooBoxConverter(ComboBox<Language> comboBox, String selectedLanguageCode) {
			this(comboBox);
			selectItem(selectedLanguageCode);
		}
		
		@Override
		public Language fromString(String key) {
			return comboBox.getItems().stream().filter(ap -> ap.getName().equals(key)).findFirst().orElse(null);
		}

		@Override
		public String toString(Language object) {
			return object.getName();
		}
		
		private void selectItem(String selectedLanguageIdentifier) {
			Language language = comboBox.getItems().stream()
					.filter(ap -> ap.getIdentifier().equals(selectedLanguageIdentifier))
					.findFirst().orElse(comboBox.getItems().get(0));
			comboBox.getSelectionModel().select(language);
		}		
	}
}
