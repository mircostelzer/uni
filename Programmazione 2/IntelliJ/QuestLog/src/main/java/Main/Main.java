package Main;

import controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Geralt;
import model.quests.QuestLog;
import view.MainView;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Geralt geralt = new Geralt(2, 0);
        QuestLog questLog = new QuestLog();
        Controller controller = new Controller(geralt, questLog);
        MainView mainView = controller.getMainView();

        Scene scene = new Scene(mainView);
        primaryStage.setTitle("QuestLog");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}