package org.example.soluzione_2019_07_26;

import Controller.KeyHandler;
import Controller.MainGUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainGUI mg = new MainGUI();
        Scene scene = new Scene(mg, 500, 500);
        KeyHandler kh = new KeyHandler(scene, mg);
        kh.handleKeys();
        stage.setTitle("Escape!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}