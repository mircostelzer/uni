package model;

import javafx.scene.shape.Circle;

public abstract class AbstractBall implements BallsInterface {
    protected Circle circle;
    public static final double DIM = 20;
    protected Directions direction;

    public AbstractBall(double x, double y) {
        this.circle = new Circle(DIM);
        this.circle.setCenterX(x);
        this.circle.setCenterY(y);
    }

    public void pacmanEffect() {
        if (this.circle.getCenterX() < 0) {
            this.circle.setCenterX(500+this.circle.getCenterX());
        } else if (this.circle.getCenterX() > 500) {
            this.circle.setCenterX(500-this.circle.getCenterX());
        } else if (this.circle.getCenterY() < 0) {
            this.circle.setCenterY(500+this.circle.getCenterY());
        } else if (this.circle.getCenterY() > 500) {
            this.circle.setCenterY(500-this.circle.getCenterY());
        }
    }

    public void move() {
            switch (direction) {
                case Up -> this.circle.setTranslateY(this.circle.getCenterY()-10);
                case Down -> this.circle.setTranslateY(this.circle.getCenterY()+10);
                case Left -> this.circle.setTranslateX(this.circle.getCenterX()-10);
                case Right -> this.circle.setTranslateX(this.circle.getCenterX()+10);
                case UpLeft ->  { this.circle.setTranslateX(this.circle.getCenterX()-10);
                    this.circle.setTranslateY(this.circle.getCenterY()-10); }
                case UpRight -> { this.circle.setTranslateX(this.circle.getCenterX()+10);
                    this.circle.setTranslateY(this.circle.getCenterY()-10); }
                case DownLeft -> { this.circle.setTranslateX(this.circle.getCenterX()-10);
                    this.circle.setTranslateY(this.circle.getCenterY()+10); }
                case DownRight -> { this.circle.setTranslateX(this.circle.getCenterX()+10);
                    this.circle.setTranslateY(this.circle.getCenterY()+10); }
            }
    }

    public Circle getCircle() {
        return circle;
    }

}
