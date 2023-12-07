module com.example.elms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires com.dlsc.formsfx;

    opens com.example.elms to javafx.fxml;
    exports com.example.elms;
}