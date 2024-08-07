package org.example.soluzione_2018_06_15;

import Controller.MainGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) {
        MainGUI mg = new MainGUI();
        Scene scene = new Scene(mg, 510, 555);
        stage.setTitle("Lucky Click!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}