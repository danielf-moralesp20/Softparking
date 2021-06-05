package dfm.softparking.controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dfm.softparking.controllers.utils.IContainerView;
import dfm.softparking.controllers.utils.IControllerView;
import dfm.softparking.controllers.utils.UIFactory.UIModule;
import dfm.softparking.utils.UtilUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import lombok.Getter;
import lombok.Setter;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FrameController extends Stage implements IContainerView, IControllerView, Initializable {
	@Getter @Setter private Runnable dialogCloser;
	
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
    	if(Optional.ofNullable(dialogCloser).isPresent())
    		dialogCloser.run();
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
	
	public static FrameController of() {
		return (FrameController) IControllerView.of(UIModule.FRAME);
	}
	
    @FXML private ResourceBundle resources;
    @Getter @FXML private URL location;
    @Getter @FXML private StackPane globalContainer;
    @FXML private StackPane mainContainer;
    @Getter @FXML private Button btnMinimize;
}
