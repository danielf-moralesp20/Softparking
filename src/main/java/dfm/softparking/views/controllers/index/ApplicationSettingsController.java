package dfm.softparking.views.controllers.index;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;

import dfm.softparking.business.Language;
import dfm.softparking.views.controllers.FrameController;
import dfm.softparking.views.interfaces.IControllerView;
import dfm.softparking.views.interfaces.IWindowView;
import dfm.softparking.views.utils.UIFactory.UIModule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import lombok.Getter;

public class ApplicationSettingsController implements IControllerView, IWindowView, Initializable {
	@Getter private FrameController frame;
	
	public ApplicationSettingsController() {
		location = getClass().getResource("/views/index/ApplicationSettings.fxml");
		frame = FrameController.of();
	}
	
	public void initialize(URL location, ResourceBundle resources) {	
	}
	
	@FXML void btnCancelEventOnAction(ActionEvent event) {
		frame.btnCloseEventOnAction(event);
    }

    @FXML void btnSaveEventOnAction(ActionEvent event) {
    }
	
	public static ApplicationSettingsController of() {
		return (ApplicationSettingsController) IControllerView.of(UIModule.APPLICATION_SETTINGS);
	}

	@FXML private ResourceBundle resources;
	@Getter @FXML private URL location;
	@Getter @FXML private AnchorPane globalContainer;
	@FXML private JFXComboBox<Language> comboBoxLanguages;
}
