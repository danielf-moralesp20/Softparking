package dfm.softparking.controllers.index;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import dfm.softparking.business.Language;
import dfm.softparking.controllers.FrameController;
import dfm.softparking.controllers.IWindowView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
		lblMotto.setText(Language.translate(lblMotto.getText()));
		lblCredits.setText(Language.translate(lblCredits.getText()));
		txtFieldEmail.setPromptText(Language.translate(txtFieldEmail.getPromptText()));
		psswordField.setPromptText(Language.translate(psswordField.getPromptText()));
		btnLogin.setText(Language.translate(btnLogin.getText()));
	}

	@FXML void btnInfoEventOnAction(ActionEvent event) {
	}

	@FXML void btnLogInEventOnAction(ActionEvent event) {
	}

	@FXML void btnSettingsEventOnAction(ActionEvent event) {
	}
	
	@FXML private ResourceBundle resources;
    @Getter @FXML private URL location;
    @Getter @FXML private BorderPane globalContainer;
    @FXML private Label lblMotto;
    @FXML private JFXTextField txtFieldEmail;
    @FXML private JFXPasswordField psswordField;
    @FXML private JFXButton btnLogin;
    @FXML private Label lblCredits;
}
