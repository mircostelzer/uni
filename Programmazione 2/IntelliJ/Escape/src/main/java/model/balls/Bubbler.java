package model.balls;

import javafx.scene.paint.Color;
import model.AbstractBall;
import model.Directions;

public class Bubbler extends Wanderer {
    private double dimension;
    private static final Color color = Color.LIGHTBLUE;

    public Bubbler(Directions directions, double x, double y) {
        super(directions, x, y);
        this.circle.setFill(color);
        this.dimension = AbstractBall.DIM;
        this.ballType = BallType.Bubbler;
    }

    public void setDimension(double dimension) {
        this.dimension = dimension;
        this.circle.setRadius(dimension);
    }

    public double getDimension() {
        return this.dimension;
    }

}
