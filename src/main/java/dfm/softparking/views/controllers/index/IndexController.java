package dfm.softparking.views.controllers.index;

import java.net.URL;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.base.ValidatorBase;

import dfm.softparking.business.Language;
import dfm.softparking.views.controllers.FrameController;
import dfm.softparking.views.interfaces.IWindowView;
import dfm.softparking.views.utils.forms.FormControl;
import dfm.softparking.views.utils.forms.FormControl.EValidators;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.Getter;

public class IndexController extends Application implements IWindowView, Initializable {
	@Getter private FrameController frame;
	private FormControl formControl;
	
	public IndexController() {
		location = getClass().getResource("/views/index/Index.fxml");
		frame = FrameController.of();
		frame.setMaximized(true);
		
		EnumMap<EValidators, String> messages = new EnumMap<>(EValidators.class);
		messages.put(EValidators.REQUIRED,  Language.translate("FIELD_REQUIRED"));
		messages.put(EValidators.EMAIL, Language.translate("FIELD_EMAIL_FORMAT"));
		
		formControl = new FormControl(messages);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		loadResource();
		show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<ValidatorBase> aux = new ArrayList<>();
		
		aux = formControl.add(emailField, () -> emailField.validate(), EnumSet.of(EValidators.REQUIRED, EValidators.EMAIL));
		emailField.getValidators().setAll(aux);
		
		aux = formControl.add(passwordField, () -> passwordField.validate(), EnumSet.of(EValidators.REQUIRED));
		passwordField.getValidators().setAll(aux);
	}

	@FXML void btnInfoEventOnAction(ActionEvent event) {
	}

	@FXML void btnLogInEventOnAction(ActionEvent event) {
		if(formControl.validate()) {
			// TODO: Handle form correct	
		}
	}

	@FXML void btnSettingsEventOnAction(ActionEvent event) {
		ApplicationSettingsController.of().showOverParent(getFrame().getGlobalContainer());
	}
	
	@FXML private ResourceBundle resources;
    @Getter @FXML private URL location;
    @Getter @FXML private BorderPane globalContainer;
    @FXML private JFXTextField emailField;
    @FXML private JFXPasswordField passwordField;
}

