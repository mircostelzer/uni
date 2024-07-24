package sampleFX;

import visual.GUI.FurnacePane;
import visual.GUI.InventoryPane;
import data.blocks.AirBlock;
import data.blocks.solids.GlassBlock;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import visual.GUI.MainGui;
import visual.GUI.MapPane;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        MainGui mainGui = new MainGui();
        Scene scene = new Scene(mainGui, 800, 560);
        primaryStage.setTitle("Minecraft");
        primaryStage.setScene(scene);
        // primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}