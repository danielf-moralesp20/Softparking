package dfm.softparking.controllers;

import dfm.softparking.utils.UtilUI;

public interface IWindowView extends IControllerView {
	
	default public void loadResource() {
		getFrame().loadResource();
		UtilUI.loadResourceFXML(this, getLocation());
	}
	
	public FrameController getFrame();
	
	public default void show() {
		getFrame().add(getGlobalContainer());
		getFrame().show();
	}
}
