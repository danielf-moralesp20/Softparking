package dfm.softparking.controllers;

import javafx.scene.layout.Pane;

public interface IControllerView {
	
	public void loadResource();
	
	public Pane getRootContainer();
	
	public void add(int pos, Pane view);
}
