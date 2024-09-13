package sampleFX;

import controller.Controller;
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
        MainGui mainGui = new MainGui(player);

        Scene scene = new Scene(mainGui, 500, 500);
        Controller controller = new Controller(player, scene, mainGui);
        primaryStage.setTitle("Escape!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}