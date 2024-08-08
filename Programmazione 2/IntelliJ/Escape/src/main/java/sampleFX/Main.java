package sampleFX;

import controller.MainGui;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Player;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Player player = new Player();
        MainGui root = new MainGui(player);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Escape!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}