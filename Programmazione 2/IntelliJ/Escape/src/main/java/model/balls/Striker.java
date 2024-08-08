package model.balls;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.AbstractBall;
import model.Directions;


public class Striker extends AbstractBall {
    private static final Color color = Color.BLUE;

    public Striker(Directions direction, double x, double y) {
        super(direction, x, y);
        this.direction = direction;
        this.circle.setFill(color);
        this.ballType = BallType.Striker;
    }

}
