import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {
    int n = 10;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Deck deck = new Deck();
        HBox box = new HBox();
        AnchorPane root = new AnchorPane();
        Button shuffle = new Button("Shuffle");
        Button deal = new Button("Deal");
        ChoiceBox<Integer> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                choiceBox.getSelectionModel().select(t1.intValue());
                n = choiceBox.getValue();
            }
        });
        box.getChildren().addAll(shuffle, deal, choiceBox);
        box.setSpacing(10);
        box.setAlignment(Pos.BOTTOM_CENTER);
        Image image = new Image("file:/home/mirco/Downloads/4102018carteramino3.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(250);
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        imageView.setX(120);
        imageView.setY(80);
        root.setBackground(new Background(new BackgroundFill(Paint.valueOf("ROYALBLUE"), new CornerRadii(0), new Insets(0))));
        root.getChildren().addAll(box, imageView);
        AnchorPane.setBottomAnchor(box, 100.0);
        AnchorPane.setLeftAnchor(box, 150.0);

        Scene scene = new Scene(root, 500, 400, Color.ROYALBLUE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cards");
        primaryStage.show();

        shuffle.setOnMouseClicked(mouseEvent -> deck.shuffle());
        deal.setOnMouseClicked(mouseEvent -> {
            deck.deal(n);
            boolean win = false;

            Text text = new Text();
            StackPane root1 = new StackPane(text);
            Scene scene1 = new Scene(root1, 200, 150);
            Stage stage1 = new Stage();

            for (int i = 0; i < n && !win; i++) {
                Card curr = deck.getCard(i);
                for (int j = 0; j < i; j++) {
                    Card check = deck.getCard(j);
                    if (curr.equals(check)) {
                        text.setText("Hai vinto!");
                        text.setTextAlignment(TextAlignment.CENTER);
                        text.setFont(Font.font("Arial"));
                        text.setFont(new Font(24));
                        root1.setBackground(new Background(new BackgroundFill(Paint.valueOf("GREEN"), new CornerRadii(0), new Insets(0))));
                        stage1.setScene(scene1);
                        stage1.show();
                        primaryStage.close();
                        win = true;
                    }
                }
            }
            if (!win) {
                text.setText("Hai perso");
                text.setFill(Color.BLACK);
                text.setFont(Font.font("Arial"));
                text.setFont(Font.font(24));
                text.setTextAlignment(TextAlignment.CENTER);
                root1.setBackground(new Background(new BackgroundFill(Paint.valueOf("RED"), new CornerRadii(0), new Insets(0))));
                stage1.setScene(scene1);
                stage1.sizeToScene();
                stage1.show();
                primaryStage.close();

            }

        });
    }

    public static void main(String[] args) {
        launch();
    }
}