package com.dfm.softparking.views.interfaces;

import java.net.URL;

import com.dfm.softparking.views.utils.UIFactory;
import com.dfm.softparking.views.utils.UtilUI;
import com.dfm.softparking.views.utils.UIFactory.UIModule;

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
