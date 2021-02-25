package dfm.softparking.controllers;

public interface IWindowView extends IControllerView {
	
	public FrameController getFrame();
	
	public default void show() {
		getFrame().add(getGlobalContainer());
		getFrame().show();
	}
}
