module dfm.softparking {
    requires java.desktop;
    requires java.persistence;
    requires java.sql;
    
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    requires com.jfoenix;
    
    requires lombok;
    requires transitive org.mapstruct.processor;
    
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.icomoon;
    requires org.kordamp.ikonli.materialdesign;
    requires org.kordamp.ikonli.fontawesome5;
    
    requires org.hibernate.orm.core;
    
    opens dfm.softparking.views.controllers to javafx.fxml;
    opens dfm.softparking.views.controllers.index to javafx.graphics, javafx.fxml;
	opens dfm.softparking.views.controllers.application.menu to javafx.fxml;
	opens dfm.softparking.database.entities to org.hibernate.orm.core;
}
