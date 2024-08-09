package model;

import javafx.scene.shape.Circle;
import model.balls.BallType;

public abstract class AbstractBall implements BallsInterface {
    protected Circle circle;
    public static final double DIM = 20;
    protected Directions direction;
    protected BallType ballType;

    public AbstractBall(Directions direction, double x, double y) {
        this.circle = new Circle();
        this.circle.setRadius(DIM);
        this.direction = direction;
        this.circle.setCenterX(x);
        this.circle.setCenterY(y);
    }

    public void pacmanEffect() {
        if (this.circle.getCenterX() < 0) {
            this.circle.setCenterX(500+this.circle.getCenterX());
        } else if (this.circle.getCenterX() > 500) {
            this.circle.setCenterX(this.circle.getCenterX()-500);
        } else if (this.circle.getCenterY() < 0) {
            this.circle.setCenterY(500+this.circle.getCenterY());
        } else if (this.circle.getCenterY() > 500) {
            this.circle.setCenterY(this.circle.getCenterY()-500);
        }
    }

    public void move() {
            switch (direction) {
                case Up -> this.circle.setCenterY(this.circle.getCenterY()-10);
                case Down -> this.circle.setCenterY(this.circle.getCenterY()+10);
                case Left -> this.circle.setCenterX(this.circle.getCenterX()-10);
                case Right -> this.circle.setCenterX(this.circle.getCenterX()+10);
                case UpLeft ->  { this.circle.setCenterX(this.circle.getCenterX()-10);
                    this.circle.setCenterY(this.circle.getCenterY()-10); }
                case UpRight -> { this.circle.setCenterX(this.circle.getCenterX()+10);
                    this.circle.setCenterY(this.circle.getCenterY()-10); }
                case DownLeft -> { this.circle.setCenterX(this.circle.getCenterX()-10);
                    this.circle.setCenterY(this.circle.getCenterY()+10); }
                case DownRight -> { this.circle.setCenterX(this.circle.getCenterX()+10);
                    this.circle.setCenterY(this.circle.getCenterY()+10); }
            }
    }

    public Circle getCircle() {
        return circle;
    }

    public BallType getBallType() {
        return ballType;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

}
