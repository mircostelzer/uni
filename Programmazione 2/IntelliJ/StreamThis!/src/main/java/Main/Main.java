package Main;

import controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.FilmCatalog;
import view.MainGui;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FilmCatalog filmCatalog = new FilmCatalog();
        Controller controller = new Controller(filmCatalog);
        MainGui mainGui = controller.getMainGui();


        Scene scene = new Scene(mainGui, 450, 250);
        primaryStage.setTitle("StreamThis!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}