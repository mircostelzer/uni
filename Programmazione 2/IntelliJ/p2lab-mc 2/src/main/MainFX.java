package main;

import controller.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import visual.GUI.MainGUI;


public class MainFX extends Application {
//    MainController mc;

    @Override
    public void start(Stage stage) throws Exception{
//        mc = new MainController();

        MainGUI layout = new MainGUI();
//                mc.getMainGUI();
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}