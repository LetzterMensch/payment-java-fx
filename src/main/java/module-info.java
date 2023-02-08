module com.example.bikerenting {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires mysql.connector.java;

    opens com.example.bikerenting to javafx.fxml;
    exports com.example.bikerenting;
    exports com.example.bikerenting.screen_controller;
    opens com.example.bikerenting.screen_controller to javafx.fxml;
}