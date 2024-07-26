package sampleFX;

import Controllers.*;
import data.BlockFactory;
import visual.GUI.FurnacePane;
import visual.GUI.InventoryPane;
import data.blocks.AirBlock;
import data.blocks.solids.GlassBlock;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import visual.GUI.MainGui;
import visual.GUI.MapPane;
import visual.textual.Furnace;
import visual.textual.Inventory;
import visual.textual.MainView;
import visual.textual.Map;


public class Main extends Application {

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