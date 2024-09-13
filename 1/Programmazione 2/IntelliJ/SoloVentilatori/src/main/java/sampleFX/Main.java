package sampleFX;

import controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.FanCatalog;
import model.User;
import view.MainGui;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        User user = new User();
        FanCatalog fanCatalog = new FanCatalog();
        Controller controller = new Controller(user, fanCatalog);
        MainGui mainGui = controller.getMainGui();

        Scene scene = new Scene(mainGui);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}