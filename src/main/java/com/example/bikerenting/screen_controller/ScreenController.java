package com.example.bikerenting.screen_controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ScreenController {
    protected FXMLLoader loader;
    protected AnchorPane root;
    private Scene scene;
    protected final Stage stage;

    public ScreenController(String screenPath) throws Exception {
        this.loader = new FXMLLoader(getClass().getResource(screenPath));
        this.loader.setController(this);
        this.root = (AnchorPane)loader.load();
        this.stage = new Stage();
    }
    public ScreenController() {
        this.stage = new Stage();
    }
    public ScreenController(Stage stage, String screenPath) throws Exception {

        this.loader = new FXMLLoader(getClass().getResource(screenPath));
//        this.loader.setController(this);
        this.root = (AnchorPane)loader.load();
        this.stage = stage;
    }
    public void show(){
        if(this.scene == null){
            this.scene = new Scene(this.root);
        }
        this.stage.setScene(this.scene);
        this.stage.show();
    }
    public void setStageTitle(String title){
        this.stage.setTitle(title);
    }
    public AnchorPane getRoot() {
        return this.root;
    }

    public FXMLLoader getLoader() {
        return this.loader;
    }
}