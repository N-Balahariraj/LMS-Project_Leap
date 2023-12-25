module com.example.elms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires com.dlsc.formsfx;

    opens com.example.elms to javafx.fxml;
    exports com.example.elms;
    exports com.example.elms.AppControllers;
    opens com.example.elms.AppControllers to javafx.fxml;
    exports com.example.elms.Helpers;
    opens com.example.elms.Helpers to javafx.fxml;
    exports com.example.elms.TableControllers;
    opens com.example.elms.TableControllers to javafx.fxml;
    exports com.example.elms.Schema;
    opens com.example.elms.Schema to javafx.base;
}