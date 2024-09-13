package com.soluzione_2019_02_15;

import Controller.MainGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) {
        MainGUI layout = new MainGUI();
        Scene scene = new Scene(layout, 800, 400);
        stage.setTitle("AAA");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}