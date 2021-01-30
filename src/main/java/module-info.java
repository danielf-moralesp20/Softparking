module dfm.softparking {
    requires java.desktop;
    requires java.persistence;
    
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    requires com.jfoenix;
    
    requires lombok;
    requires transitive org.mapstruct.processor;
    
    requires org.kordamp.ikonli.icomoon;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign;
    
    opens dfm.softparking to javafx.graphics;
	opens dfm.softparking.controllers.index to javafx.fxml;
	opens dfm.softparking.controllers to javafx.fxml;
}

