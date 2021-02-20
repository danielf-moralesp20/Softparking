package dfm.softparking.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import dfm.softparking.utils.UtilUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import lombok.Getter;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FrameController extends Stage implements IContainerView, IControllerView, Initializable {
	public FrameController() {
		location = getClass().getResource("/views/Frame.fxml");
		super.initStyle(StageStyle.UNDECORATED);
		super.setTitle("Softparking");
	}
	
	@Override
    public void initialize(URL location, ResourceBundle resources) {
		super.setScene(new Scene(globalContainer));
    }
	
    @FXML public void btnCloseEventOnAction(ActionEvent event) {
    	super.close();
    }

    @FXML public void btnMinimizeEventOnAction(ActionEvent event) {
    	super.setIconified(true);
	}
	
	@Override
	public void add(int pos, Pane view) {
		switch (pos) {
			case MAIN_CONTAINER:
				UtilUI.add(mainContainer, view);
				break;
		}
	}
	
    @FXML private ResourceBundle resources;
    @Getter @FXML private URL location;
    @Getter @FXML private VBox globalContainer;
    @FXML private StackPane mainContainer;
}
