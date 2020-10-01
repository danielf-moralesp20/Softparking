module dfm.softparking {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.persistence;
      
    requires lombok;
    requires transitive org.mapstruct.processor;
    
    requires org.kordamp.ikonli.icomoon;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign;
    
    opens dfm.softparking to javafx.graphics;
}
