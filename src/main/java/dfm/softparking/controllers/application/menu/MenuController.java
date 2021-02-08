package dfm.softparking.controllers.application.menu;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import dfm.softparking.business.Language;
import dfm.softparking.controllers.IControllerView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import lombok.Getter;

public class MenuController implements IControllerView, Initializable {
	public MenuController() {
		location = getClass().getResource("/dfm/softparking/views/application/menu/Menu.fxml");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		btnParking.setText(Language.translate(btnParking.getText()));
	    btnTickets.setText(Language.translate(btnTickets.getText()));
	    btnUsers.setText(Language.translate(btnUsers.getText()));
	    btnCustomers.setText(Language.translate(btnCustomers.getText()));
	    btnReports.setText(Language.translate(btnReports.getText()));
	    btnSettings.setText(Language.translate(btnSettings.getText()));
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
    @FXML private JFXButton btnParking; 
    @FXML private JFXButton btnTickets;
    @FXML private JFXButton btnUsers;
    @FXML private JFXButton btnCustomers;
    @FXML private JFXButton btnReports;
    @FXML private JFXButton btnSettings;
}
