package org.example.soluzione_2018_09_11;

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
        Scene scene = new Scene(mg, 500, 300);
        stage.setTitle("BlackJack");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}