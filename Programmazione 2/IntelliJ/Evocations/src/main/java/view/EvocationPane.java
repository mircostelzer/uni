package view;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.evocations.AbstractEvocation;
import model.evocations.SupremeEvocation;

public class EvocationPane extends StackPane {
    private Text text;
    private Rectangle rectangle;
    private AbstractEvocation evocation;
    private final Color FIRE = Color.FIREBRICK;
    private final Color WATER = Color.AQUAMARINE;
    private final Color DARKNESS = Color.DARKVIOLET;
    private final Color NEUTRAL = Color.HONEYDEW;
    private final int RECT_DIM = 100;

    public EvocationPane(AbstractEvocation evocation) {
        this.evocation = evocation;
    }

    public void redraw() {
        this.getChildren().clear();
        rectangle = new Rectangle(RECT_DIM, RECT_DIM);
        switch (evocation.getType()) {
            case Fire -> rectangle.setFill(FIRE);
            case Water -> rectangle.setFill(WATER);
            case Darkness -> rectangle.setFill(DARKNESS);
            case Neutral -> rectangle.setFill(NEUTRAL);
        }
        if (evocation instanceof SupremeEvocation) {
            rectangle.setStrokeWidth(3);
        }

        text = new Text(evocation.toString());
        this.getChildren().addAll(rectangle, text);
    }
}
