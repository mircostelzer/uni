package Main;

import gui.MainGui;
import gui.PlayerPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Direction;
import model.Player;
import model.entities.Character;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Player player = new Player();
        MainGui mainGui = new MainGui(player);

        Scene scene = new Scene(mainGui);
        mainGui.setScene(scene);
        primaryStage.setTitle("Run!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}