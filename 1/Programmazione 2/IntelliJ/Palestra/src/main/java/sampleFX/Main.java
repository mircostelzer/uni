package sampleFX;

import controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Archive;
import view.MainGui;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Archive archive = new Archive();
        Controller controller = new Controller(archive);
        MainGui mainGui = controller.getMainGui();

        Scene scene = new Scene(mainGui, 500, 250);
        primaryStage.setTitle("Palestra");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}