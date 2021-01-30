package dfm.softparking.controllers.index;

import java.net.URL;
import java.util.ResourceBundle;

import dfm.softparking.controllers.FrameController;
import dfm.softparking.controllers.IWindowView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import lombok.Getter;

public class IndexController implements IWindowView, Initializable {
	@Getter private FrameController frame;
	
	public IndexController() {
		location = getClass().getResource("/dfm/softparking/views/index/Index.fxml");
		frame = new FrameController();
		frame.setMaximized(true);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
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
}
