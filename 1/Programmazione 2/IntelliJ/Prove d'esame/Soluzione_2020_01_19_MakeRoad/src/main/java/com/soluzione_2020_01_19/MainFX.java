package com.soluzione_2020_01_19;

import Controller.KeyHandler;
import Controller.MainGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) {
        MainGUI mg = new MainGUI();
        Scene scene = new Scene(mg, 460, 550);
        KeyHandler kh = new KeyHandler(scene, mg);
        kh.handleKeysPressed();
        scene.setFill(Color.GRAY);
        stage.setTitle("Make a road!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}