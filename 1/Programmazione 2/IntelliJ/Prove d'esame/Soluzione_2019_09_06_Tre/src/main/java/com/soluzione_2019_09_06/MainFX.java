package com.soluzione_2019_09_06;

import Controller.KeyHandler;
import Controller.MainGUI;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {
    private final static double LATO_EMPTY_FIGURE = 50;
    private final static double LATO_TRIANGOLO = 55;
    private final static double RAGGIO_CERCHIO = 25;

    @Override
    public void start(Stage stage){
        MainGUI mg = new MainGUI();
        Scene scene = new Scene(mg, 270, 315);
        mg.setAlignment(Pos.BOTTOM_CENTER);
        KeyHandler kh = new KeyHandler(mg, scene);
        kh.handleKeys();
        stage.setTitle("TRE!");
        stage.setScene(scene);
        stage.show();
    }

    public static double getLATO_EMPTY_FIGURE() {
        return LATO_EMPTY_FIGURE;
    }

    public static double getLATO_TRIANGOLO() {
        return LATO_TRIANGOLO;
    }

    public static double getRAGGIO_CERCHIO() {
        return RAGGIO_CERCHIO;
    }

    public static void main(String[] args) {
        launch();
    }
}