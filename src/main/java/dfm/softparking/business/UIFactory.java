package dfm.softparking.business;

import dfm.softparking.controllers.FrameController;
import dfm.softparking.controllers.IControllerView;
import dfm.softparking.controllers.index.IndexController;

public class UIFactory {
	public static final int FRAME = 0;
	public static final int INDEX = 1;
	
	public static IControllerView buildView(int view) {
		IControllerView controllerView = null;
		
		switch (view) {
			case FRAME:
				controllerView = new FrameController();
				break;
				
			case INDEX:
				controllerView = new IndexController();
				break;
		}
		
		if(controllerView != null) controllerView.loadResource();
		return controllerView;
	}
}
