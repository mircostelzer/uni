package sampleFX;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Cell extends StackPane {
    private String content;
    private Rectangle rectangle;
    private Text text;
    private int x;
    private int y;
    private Controller controller;

    public final static int DIM = 50;

    public Cell(String content, int x, int y, Controller controller) {
        this.content = content;
        this.x = x;
        this.y = y;
        this.controller = controller;

        this.setOnMouseClicked(new ClickListener(controller, x, y));
        this.redraw();
    }

    private void addText() {
        this.text = new Text(this.content);
        this.text.setFont(Font.font("VERDANA", FontWeight.SEMI_BOLD, 20));
        this.getChildren().add(this.text);
    }

    private void setContent(String content) {
        this.content = content;
    }
     public void redraw() {
         this.rectangle = new Rectangle(50, 50);
         rectangle.setStroke(Paint.valueOf("BLACK"));
         rectangle.setStrokeWidth(2);
         rectangle.setFill(Paint.valueOf("LIGHTBLUE"));
         this.getChildren().add(rectangle);
         this.addText();
     }
}
