package com.dfm.softparking.views.utils;

import java.util.function.Supplier;

import com.dfm.softparking.views.controllers.FrameController;
import com.dfm.softparking.views.controllers.application.menu.MenuController;
import com.dfm.softparking.views.controllers.index.ApplicationSettingsController;
import com.dfm.softparking.views.controllers.index.IndexController;
import com.dfm.softparking.views.interfaces.IControllerView;

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
