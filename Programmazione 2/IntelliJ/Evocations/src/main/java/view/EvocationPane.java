package view;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Energy;
import model.evocations.AbstractEvocation;
import model.evocations.SupremeEvocation;

public class EvocationPane extends StackPane {
    private Text text;
    private Rectangle rectangle;
    private AbstractEvocation evocation;
    public static final Color FIRE = Color.FIREBRICK;
    public static final Color WATER = Color.AQUAMARINE;
    public static final Color DARKNESS = Color.DARKVIOLET;
    public static final Color NEUTRAL = Color.HONEYDEW;
    private final int RECT_DIM = 100;

    public EvocationPane(AbstractEvocation evocation) {
        this.evocation = evocation;
        this.redraw();
    }

    public void redraw() {
        this.getChildren().clear();
        rectangle = new Rectangle(RECT_DIM, RECT_DIM);
        rectangle.setFill(EvocationPane.getColor(evocation.getType()));
        if (evocation instanceof SupremeEvocation) {
            rectangle.setStroke(Paint.valueOf("BLACK"));
            rectangle.setStrokeWidth(5);
        }

        text = new Text(evocation.toString());
        this.getChildren().addAll(rectangle, text);
    }

    static Color getColor(Energy energy) {
        return switch (energy) {
            case Fire -> FIRE;
            case Water -> WATER;
            case Darkness -> DARKNESS;
            case Neutral -> NEUTRAL;
        };
    }
}
