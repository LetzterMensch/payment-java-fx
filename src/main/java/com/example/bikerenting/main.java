package com.example.bikerenting;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try{
            PayMethodSelection payMethodSelection = new PayMethodSelection(stage,"/payMethodSelection.fxml");
            payMethodSelection.setStageTitle("Select a payment method");
            payMethodSelection.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}