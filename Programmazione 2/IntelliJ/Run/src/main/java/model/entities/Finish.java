package model.entities;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Finish extends NonPlayerEntity implements Entity{
    private final Color COLOR = Color.LIGHTBLUE;
    private final double WIDTH = 10;
    private final double HEIGHT = 200;

    public Finish(int x, int y) {
        this.shape = new Rectangle(x, y, WIDTH, HEIGHT);
        this.shape.setFill(COLOR);
    }

    public Rectangle getShape() {
        return (Rectangle) this.shape;
    }
}
