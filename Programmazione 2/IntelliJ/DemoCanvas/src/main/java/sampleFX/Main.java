package sampleFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.effect.Effect;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(800, 600);
        Group root = new Group(canvas);
        Scene scene = new Scene(root, 800, 600);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.fillOval(300, 200, 300, 200);
        Effect effect = new GaussianBlur(30);
        graphicsContext.setFill(Paint.valueOf("Red"));
        graphicsContext.setEffect(effect);
        canvas.setEffect(effect);
        primaryStage.setTitle("Canvas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}