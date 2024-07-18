import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Deck deck = new Deck();
        HBox root = new HBox();
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);
        Button shuffle = new Button("Shuffle");
        Button deal = new Button("Deal");
        root.getChildren().addAll(shuffle, deal);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        primaryStage.setTitle("Cards");
        primaryStage.show();

        Pane root1 = new StackPane();
        Scene scene1 = new Scene(root1, 200, 150);
        Stage stage1 = new Stage();
        stage1.setScene(scene1);
        Text text = new Text();

        shuffle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                      @Override
                                      public void handle(MouseEvent mouseEvent) {
                                          deck.shuffle();
                                      }
        });
        deal.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                deck.deal(10);
                boolean win = false;
                for (int i = 0; i < 10 && !win; i++) {
                    Card curr = deck.getCard(i);
                    for (int j = 0; j < i; j++) {
                        Card check = deck.getCard(j);
                        if (curr.equals(check)) {
                            scene1.setFill(Color.GREEN);
                            text.setText("Hai vinto!");
                            text.setFill(Color.BLACK);
                            text.setFont(Font.font("Arial"));
                            text.setFont(Font.font(18));
                            root1.getChildren().add(text);
                            stage1.show();
                            win = true;
                        }
                    }
                }
                if (!win) {
                    scene1.setFill(Color.RED);
                    text.setText("Hai perso");
                    text.setFill(Color.BLACK);
                    text.setFont(Font.font("Arial"));
                    text.setFont(Font.font(18));
                    root1.getChildren().add(text);
                    stage1.show();

                }

            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}