package com.soluzione_2023_09_08;

import Controller.MainGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) {
        MainGUI mg = new MainGUI();
        Scene scene = new Scene(mg, 440, 250);
        stage.setTitle("StreamThis!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}