package Main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Player;
import model.entities.Character;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Player player = new Player();
        Character character = new Character(player);
        Group group = character.getGroup();
        group.setLayoutX(50);
        group.setLayoutY(50);
        Scene scene = new Scene(group, 300, 250);
        primaryStage.setTitle("Run!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}