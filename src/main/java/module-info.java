module com.devmarco.linearmind {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.devmarco.linearmind.controllers to javafx.fxml;
    exports com.devmarco.linearmind.controllers;

    opens com.devmarco.linearmind to javafx.fxml;
    exports com.devmarco.linearmind;
}