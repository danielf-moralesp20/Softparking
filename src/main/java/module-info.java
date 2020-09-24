module dfm.softparking {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.persistence;
      
    requires lombok;
    requires transitive org.mapstruct.processor;
    
    opens dfm.softparking to javafx.graphics;
}
