package com.dfm.softparking.views.interfaces;

import com.dfm.softparking.views.controllers.FrameController;
import com.jfoenix.controls.JFXDialog;

import javafx.scene.Node;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.StackPane;

public interface IWindowView extends IControllerView {
	
	public FrameController getFrame();
	
	public default void show() {
		getFrame().add(getGlobalContainer());
		getFrame().show();
	}
	
	public default void showOverParent(StackPane parent) {
		getFrame().add(getGlobalContainer());
		
		JFXDialog dialog = new JFXDialog(parent, getFrame().getGlobalContainer(), JFXDialog.DialogTransition.CENTER);
		BoxBlur effect = new BoxBlur(3, 3, 3);
		Node child = parent.getChildren().get(0);
		
		child.setEffect(effect);
		child.setDisable(true);
		getFrame().setDialogCloser(() -> dialog.close());
		getFrame().getBtnMinimize().setVisible(false);
		
		dialog.setOnDialogClosed((evt) -> {
			child.setEffect(null);
			child.setDisable(false);
			getFrame().setDialogCloser(null);
		});
		
		dialog.show();
	}
}
