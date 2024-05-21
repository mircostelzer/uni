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
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        root.getChildren().add(btn);
        MainGui mainGui = new MainGui();
        Scene scene = new Scene(mainGui, 300, 250);
        primaryStage.setTitle("Minecraft");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();

    }
}