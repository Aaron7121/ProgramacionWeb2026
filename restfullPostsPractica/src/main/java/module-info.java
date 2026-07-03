module com.programacion.web.restfullpostspractica {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.programacion.web.restfullpostspractica to javafx.fxml;
    exports com.programacion.web.restfullpostspractica;
}