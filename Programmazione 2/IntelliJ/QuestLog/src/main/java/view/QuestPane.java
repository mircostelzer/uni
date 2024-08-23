package view;

import controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.quests.QuestInterface;

import java.util.Stack;

public class QuestPane extends VBox {
    private StackPane stackPane;
    private Rectangle rectangle;
    private Text text;
    private Button complete;
    private QuestInterface quest;
    private final Color NOT_COMPLETED = Color.BEIGE;
    private final Color COMPLETED = Color.LIGHTGREEN;
    public static final int RECT_LENGHT = 240;
    private Controller controller;

    public QuestPane(QuestInterface quest, Controller controller) {
        this.quest = quest;
        this.controller = controller;
        this.rectangle = new Rectangle(RECT_LENGHT, 60);
        this.text = new Text(quest.toString());
        text.setTextAlignment(TextAlignment.JUSTIFY);
        this.complete = new Button("Completa");
        complete.setOnMouseClicked(e -> {
            this.controller.complete(this.quest);
        });
        this.setAlignment(Pos.CENTER);
        this.redraw();
    }

    public void redraw() {
        this.getChildren().clear();
        this.stackPane = new StackPane();
        if (quest.isCompleted()) {
            rectangle.setFill(COMPLETED);
            complete.setDisable(true);
        } else {
            rectangle.setFill(NOT_COMPLETED);
        }
        complete.setAlignment(Pos.CENTER);
        stackPane.getChildren().addAll(rectangle, text);
        this.getChildren().addAll(stackPane, complete);
    }
}
