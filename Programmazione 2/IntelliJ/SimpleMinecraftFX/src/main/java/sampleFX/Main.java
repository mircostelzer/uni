package sampleFX;

import GUI.BlockPane;
import GUI.InventoryPane;
import GUI.MapPane;
import data.blocks.SandBlock;
import data.blocks.WaterBlock;
import data.blocks.solids.GlassBlock;
import data.blocks.solids.RawIronBlock;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import visual.Inventory;

import java.util.Scanner;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        root.getChildren().add(btn);
        MapPane mapPane = new MapPane();
        Scene scene = new Scene(mapPane, 300, 250);
        primaryStage.setTitle("Minecraft");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();

    }
}