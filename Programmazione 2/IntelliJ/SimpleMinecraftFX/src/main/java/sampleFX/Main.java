package sampleFX;

import Controllers.FurnaceSimpleController;
import Controllers.InventorySimpleController;
import Controllers.MapSimpleController;
import Controllers.SimpleController;
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
import visual.textual.Map;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

//        MainGui mainGui = new MainGui();
//        Scene scene = new Scene(mainGui, 800, 560);
        MapPane mapPane = new MapPane();
        Map map = new Map();
        MapSimpleController mapController = new MapSimpleController(map, mapPane);


        Scene scene = new Scene(mapPane);
        primaryStage.setTitle("Minecraft");
        primaryStage.setScene(scene);
        // primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}