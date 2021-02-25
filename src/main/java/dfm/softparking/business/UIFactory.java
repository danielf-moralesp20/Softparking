package dfm.softparking.business;

import dfm.softparking.controllers.FrameController;
import dfm.softparking.controllers.IControllerView;
import dfm.softparking.controllers.application.menu.MenuController;
import dfm.softparking.controllers.index.IndexController;

public class UIFactory {
	public static enum UIModule {
		FRAME,
		INDEX,
		MENU
	}
	
	public static IControllerView buildView(UIModule module) {
		IControllerView controllerView = null;
		
		switch (module) {
			case FRAME:
				controllerView = new FrameController();
				break;
				
			case INDEX:
				controllerView = new IndexController();
				break;
				
			case MENU:
				controllerView = new MenuController();
				break;
		}
		
		if(controllerView != null) controllerView.loadResource();
		return controllerView;
	}
}
