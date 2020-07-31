module dfm.softparking {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens dfm.softparking to javafx.fxml;
    exports dfm.softparking;
}