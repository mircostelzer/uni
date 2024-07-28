package sampleFX;

import controllers.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import visual.GUI.MainGui;
import visual.textual.MainView;


public class MainFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        MainSimpleController mc = new MainSimpleController(new MainView());
        MainGui layout = mc.getMainGui();
        Scene scene = new Scene(layout);

        primaryStage.setTitle("Minecraft");
        primaryStage.setScene(scene);
        // primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}