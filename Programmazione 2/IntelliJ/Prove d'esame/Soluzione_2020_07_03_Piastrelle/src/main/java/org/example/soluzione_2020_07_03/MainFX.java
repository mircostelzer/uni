package org.example.soluzione_2020_07_03;

import Controller.MainGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) {
        MainGUI mg = new MainGUI();
        Scene scene = new Scene(mg, 300, 180);
        stage.setTitle("Catalogo Piastrelle");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}