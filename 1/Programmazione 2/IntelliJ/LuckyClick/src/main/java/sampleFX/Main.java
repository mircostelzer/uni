package sampleFX;

import controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Grid;
import model.Player;
import model.cells.BaseCell;
import model.cells.BombCell;
import view.CellPane;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Player player = new Player(20);
        Grid grid = new Grid(player);
        Controller controller = new Controller(grid, player);
        Scene scene = new Scene(controller.getMainGui());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}