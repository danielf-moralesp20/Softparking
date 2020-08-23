module dfm.softparking {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.persistence;
    
    opens dfm.softparking to javafx.fxml;
    exports dfm.softparking;
}