package main;

import controller.simple.MainSimpleController;
import controller.textual.TextMainUIController;
import data.model.MainFunctionalities;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.GUI.MainGUI;


public class MainFX_FineGrained extends Application {
    MainSimpleController mc;

    @Override
    public void start(Stage stage) throws Exception{
        mc = new MainSimpleController(new MainFunctionalities());

        MainGUI layout = mc.getMainGUI();
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}