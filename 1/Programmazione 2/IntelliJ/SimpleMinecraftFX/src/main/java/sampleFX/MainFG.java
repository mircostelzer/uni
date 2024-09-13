package sampleFX;

import controllers.MainSimpleController;
import controllers.fine_grained.FGMainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import visual.GUI.MainGui;
import visual.textual.MainView;

public class MainFG extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        FGMainController mc = new FGMainController(new MainView());
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
