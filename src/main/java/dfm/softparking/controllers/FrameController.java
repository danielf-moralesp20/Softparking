package dfm.softparking.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import dfm.softparking.runtime.AppRuntime;
import dfm.softparking.utils.UtilUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lombok.Getter;

public class FrameController implements IControllerView, Initializable {
	public static final int MAIN_YIELD = 0;
	
	public FrameController() {
		location = getClass().getResource("/dfm/softparking/views/Frame.fxml");
	}
	
    @FXML public void btnCloseEventOnAction(ActionEvent event) {
		AppRuntime.getInstance().closeApplication();
    }

    @FXML public void btnMinimizeEventOnAction(ActionEvent event) {
		AppRuntime.getInstance().getUiRuntime().minimizeWindow(this);
	}

    @Override
    public void initialize(URL locationUrl, ResourceBundle resources) {
    	assert rootContainer != null : "fx:id=\"rootContainer\" was not injected: check your FXML file 'Frame.fxml'.";
    	assert mainYield != null : "fx:id=\"mainYield\" was not injected: check your FXML file 'Frame.fxml'.";
    }
    
	@Override
	public void loadResource() {
		UtilUI.loadResourceFXML(this, location);
	}

	@Override
	public void add(int pos, Pane view) {
		switch (pos) {
			case MAIN_YIELD:
			default:
				UtilUI.add(mainYield, view);
				break;
		}
	}
    
    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @Getter @FXML private VBox rootContainer;
    @FXML private AnchorPane mainYield;
}
