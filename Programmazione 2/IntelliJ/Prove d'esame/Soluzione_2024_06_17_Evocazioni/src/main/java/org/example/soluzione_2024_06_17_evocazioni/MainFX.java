package org.example.soluzione_2024_06_17_evocazioni;

import Controller.MainGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) {
        MainGUI mg = new MainGUI();
        Scene scene = new Scene(mg, 600, 600);
        stage.setTitle("Evocazioni");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}