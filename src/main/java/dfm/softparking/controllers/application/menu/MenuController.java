package dfm.softparking.controllers.application.menu;

import java.net.URL;
import java.util.ResourceBundle;

import dfm.softparking.controllers.utils.IControllerView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import lombok.Getter;

public class MenuController implements IControllerView, Initializable {
	public MenuController() {
		location = getClass().getResource("/views/application/menu/Menu.fxml");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
	}
	
	@FXML void btnCustomersEventOnAction(ActionEvent event) {
    }

    @FXML void btnParkingEventOnAction(ActionEvent event) {
    }

    @FXML void btnReportsEventOnAction(ActionEvent event) {
    }

    @FXML void btnSettingsEventOnAction(ActionEvent event) {
    }

    @FXML void btnTicketsEventOnAction(ActionEvent event) {
    }

    @FXML void btnUsersEventOnAction(ActionEvent event) {
    }
	
    @Getter @FXML private VBox globalContainer;
	@FXML private ResourceBundle resources;
    @Getter @FXML private URL location;
}
