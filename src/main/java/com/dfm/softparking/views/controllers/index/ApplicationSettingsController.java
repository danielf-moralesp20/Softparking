package com.dfm.softparking.views.controllers.index;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.dfm.softparking.business.AppDocumentProperties;
import com.dfm.softparking.business.Language;
import com.dfm.softparking.business.Language.LanguageCombooBoxConverter;
import com.dfm.softparking.views.controllers.FrameController;
import com.dfm.softparking.views.interfaces.IControllerView;
import com.dfm.softparking.views.interfaces.IWindowView;
import com.dfm.softparking.views.utils.UIFactory.UIModule;
import com.jfoenix.controls.JFXComboBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import lombok.Getter;

public class ApplicationSettingsController implements IControllerView, IWindowView, Initializable {
	@Getter private FrameController frame;
	private AppDocumentProperties appDocumentProperties;
	
	public ApplicationSettingsController() {
		location = getClass().getResource("/views/index/ApplicationSettings.fxml");
		frame = FrameController.of();
		appDocumentProperties = AppDocumentProperties.getInstance();
	}
	
	public void initialize(URL location, ResourceBundle resources) {	
		comboBoxLanguages.setItems(Language.getAvailableLanguages());
		comboBoxLanguages.setConverter(new LanguageCombooBoxConverter(comboBoxLanguages, appDocumentProperties.getLanguageCode()));
	}
	
	@FXML void btnCancelEventOnAction(ActionEvent event) {
		frame.btnCloseEventOnAction(event);
    }

    @FXML void btnSaveEventOnAction(ActionEvent event) {
    	try {
    		appDocumentProperties.setLanguageCode(comboBoxLanguages.getValue().getIdentifier());	
    		appDocumentProperties.store();
    		// TODO: Handle success on saving
		} catch (IOException e) {        	
        	// TODO: Handle error
		}
    }
	
	public static ApplicationSettingsController of() {
		return (ApplicationSettingsController) IControllerView.of(UIModule.APPLICATION_SETTINGS);
	}

	@FXML private ResourceBundle resources;
	@Getter @FXML private URL location;
	@Getter @FXML private AnchorPane globalContainer;
	@FXML private JFXComboBox<Language> comboBoxLanguages;
}
