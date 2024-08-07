package com.soluzione_2023_07_18;

import Controller.MainGUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        MainGUI mg = new MainGUI();
        Scene scene = new Scene(mg, 480, 300);
        stage.setTitle("Only Fans");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}