package com.soluzione_2018_07_05;

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
        Scene scene = new Scene(mg, 400, 200);
        stage.setTitle("Concessionaria auto");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}