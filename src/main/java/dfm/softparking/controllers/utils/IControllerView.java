package dfm.softparking.controllers.utils;

import java.net.URL;

import dfm.softparking.controllers.utils.UIFactory.UIModule;
import dfm.softparking.utils.UtilUI;
import javafx.scene.layout.Pane;

public interface IControllerView {		
	default public void loadResource() {
		UtilUI.loadResourceFXML(this, getLocation());
	}
	
	public Pane getGlobalContainer();
	
	public URL getLocation();
	
	public static IControllerView of(UIModule module) {
		return UIFactory.buildView(module);
	}
}
