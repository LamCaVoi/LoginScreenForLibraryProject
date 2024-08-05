module com.lam.librarymanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.lam.librarymanagement to javafx.fxml;
    exports com.lam.librarymanagement;
}
