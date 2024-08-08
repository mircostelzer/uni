package model.balls;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.AbstractBall;
import model.Directions;

public class UserBall extends AbstractBall {
    private static final Color color = Color.ORANGE;

    public UserBall(Directions directions, double x, double y) {
        super(directions, x, y);
        this.circle.setFill(color);

    }

}
