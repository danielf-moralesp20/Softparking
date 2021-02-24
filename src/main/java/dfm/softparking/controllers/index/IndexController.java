package dfm.softparking.controllers.index;

import java.net.URL;
import java.util.ResourceBundle;

import dfm.softparking.business.UIFactory;
import dfm.softparking.controllers.FrameController;
import dfm.softparking.controllers.IWindowView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.Getter;

public class IndexController extends Application implements IWindowView, Initializable {
	@Getter private FrameController frame;
	
	public IndexController() {
		location = getClass().getResource("/views/index/Index.fxml");
		frame = new FrameController();
		frame.setMaximized(true);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		loadResource();
		show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@FXML void btnInfoEventOnAction(ActionEvent event) {
	}

	@FXML void btnLogInEventOnAction(ActionEvent event) {
	}

	@FXML void btnSettingsEventOnAction(ActionEvent event) {
		ApplicationSettingsController settingsController = (ApplicationSettingsController) UIFactory.buildView(UIFactory.APPLICATION_SETTINGS);
		settingsController.show();
	}
	
	@FXML private ResourceBundle resources;
    @Getter @FXML private URL location;
    @Getter @FXML private BorderPane globalContainer;
}
