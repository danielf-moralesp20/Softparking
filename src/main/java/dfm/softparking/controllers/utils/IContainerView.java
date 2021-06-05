package dfm.softparking.controllers.utils;

import javafx.scene.layout.Pane;

public interface IContainerView {
	public static final int MAIN_CONTAINER = 0;

	public void add(int pos, Pane view);
	
	default public void add(Pane view) {
		add(MAIN_CONTAINER, view);
	}
}
