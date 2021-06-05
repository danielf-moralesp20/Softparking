package dfm.softparking.controllers.utils;

import java.util.function.Supplier;

import dfm.softparking.controllers.FrameController;
import dfm.softparking.controllers.application.menu.MenuController;
import dfm.softparking.controllers.index.ApplicationSettingsController;
import dfm.softparking.controllers.index.IndexController;

public class UIFactory {
	public static enum UIModule {
		FRAME(() -> new FrameController()),
		INDEX(() -> new IndexController()),
		MENU(() -> new MenuController()),
		APPLICATION_SETTINGS(() -> new ApplicationSettingsController());
		
		private Supplier<IControllerView> constructor;
		
		private UIModule(Supplier<IControllerView> constructor) {
			this.constructor = constructor;
		}
		
		public IControllerView getNewInstance() {
			return constructor.get();
		}
	}
	
	public static IControllerView buildView(UIModule module) {
		IControllerView controller = module.getNewInstance();
		controller.loadResource();
		
		return controller;
	}
}
