package view;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.cells.*;


public class CellPane extends StackPane {
    private Rectangle rectangle;
    private Text text;
    private AbstractCell content;

    public CellPane(AbstractCell content) {
        this.content = content;
        this.initialise();
    }

    private void initialise() {
        rectangle = new Rectangle(50, 50);
        if (content.isActive()) {
            this.reveal();
        } else {
            rectangle.setStroke(Paint.valueOf("BLACK"));
            rectangle.setFill(Paint.valueOf("YELLOW"));
        }
        this.getChildren().add(rectangle);
    }

    public void reveal() {
        rectangle.setStroke(Paint.valueOf("BLACK"));
        rectangle.setFill(this.getCellColor());
        this.getChildren().add(rectangle);
        text = new Text(content.getContent());
        text.setFont(Font.font("VERDANA", FontWeight.NORMAL, 15));
        this.getChildren().add(text);
    }

    private Color getCellColor() {
        if (content instanceof BaseCell) {
            return Color.WHITE;
        } else if (content instanceof MultiplierCell) {
            return Color.GREEN;
        } else if (content instanceof DividerCell) {
            return Color.RED;
        } else {
            return Color.BLUE;
        }
    }

    public void setContent(AbstractCell content) {
        this.content = content;
        this.initialise();
    }

}
