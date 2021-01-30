package dfm.softparking.controllers;

import java.net.URL;

import dfm.softparking.utils.UtilUI;
import javafx.scene.layout.Pane;

public interface IControllerView {		
	default public void loadResource() {
		UtilUI.loadResourceFXML(this, getLocation());
	}
	
	public Pane getGlobalContainer();
	
	public URL getLocation();
}
