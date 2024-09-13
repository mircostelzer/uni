package org.example.soluzione_2024_01_12;

import Controller.KeyHandler;
import Controller.MainGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) {
        MainGUI mg = new MainGUI();
        Scene scene = new Scene(mg, 500, 200);
        KeyHandler kh = new KeyHandler(scene, mg);
        kh.handleKeys();
        stage.setTitle("Run!!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}