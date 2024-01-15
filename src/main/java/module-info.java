module com.monopoly.monopoly {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires org.json;
    requires com.fasterxml.jackson.databind;

    opens com.monopoly.monopoly to javafx.fxml, com.fasterxml.jackson.databind;

    exports com.monopoly.monopoly;
}