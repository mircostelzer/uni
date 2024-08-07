package model.balls;

import javafx.scene.paint.Color;
import model.AbstractBall;
import model.Directions;

public class Bubbler extends AbstractBall {
    private double dimension;
    private static final Color color = Color.LIGHTBLUE;

    public Bubbler(double x, double y) {
        super(x, y);
        this.circle.setFill(color);
        this.dimension = AbstractBall.DIM;
    }

    public void setDimension(double dimension) {
        this.dimension = dimension;
    }

    public double getDimension() {
        return this.dimension;
    }

}
