package com.soluzione_2020_02_05;

import Controller.KeyHandler;
import Controller.MainGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) {
        MainGUI mg = new MainGUI();
        Scene scene = new Scene(mg, 250, 300);
        KeyHandler kh = new KeyHandler(scene, mg);
        kh.handleKeys();
        stage.setTitle("Numbers!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}