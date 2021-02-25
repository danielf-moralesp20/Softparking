package dfm.softparking.utils;

import java.net.URL;
import java.util.ResourceBundle;

import dfm.softparking.business.runtime.Collector;
import dfm.softparking.business.runtime.Collector.CollectorKey;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public abstract class UtilUI {
	private UtilUI() {
	}
	
	public static void loadResourceFXML(Object controller, URL urlResourceFXML) {
		FXMLLoader fxmlLoader = new FXMLLoader(urlResourceFXML);
		try {
			fxmlLoader.setController(controller);
			fxmlLoader.setResources((ResourceBundle) Collector.getCollector().get(CollectorKey.BUNDLED_LANG));
			fxmlLoader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void add(Pane containerParent, Pane containerChildren) {
		if(containerParent.getChildren().contains(containerChildren)) 
			return;
		
		containerParent.getChildren().clear();
		containerParent.getChildren().add(containerChildren);
		
		containerChildren.prefWidthProperty().bind(containerParent.prefWidthProperty());
		containerChildren.prefHeightProperty().bind(containerParent.prefHeightProperty());
	}
}
