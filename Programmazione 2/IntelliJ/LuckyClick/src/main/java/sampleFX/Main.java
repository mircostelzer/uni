package sampleFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.cells.BaseCell;
import model.cells.BombCell;
import view.CellPane;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        CellPane root = new CellPane(new BombCell());
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Lucky Click!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}