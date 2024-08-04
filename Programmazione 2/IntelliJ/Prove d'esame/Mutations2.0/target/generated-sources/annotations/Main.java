package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import view.MainPane;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        MainPane mp = new MainPane();

        StackPane root = new StackPane(mp);
        primaryStage.setTitle("Mutations");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}