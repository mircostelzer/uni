package model.balls;

import javafx.scene.paint.Color;
import model.AbstractBall;
import model.Directions;

public class Wanderer extends AbstractBall {
    private static final Color color = Color.DARKBLUE;

    public Wanderer(Directions direction, double x, double y) {
        super(direction, x, y);
        this.circle.setFill(color);
        this.ballType = BallType.Wanderer;
    }
}
