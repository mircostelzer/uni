package model;

import javafx.scene.shape.Circle;
import model.balls.BallType;

public interface BallsInterface {
    public void move();
    public void pacmanEffect();
    public Circle getCircle();
    public BallType getBallType();
    public void setDirection(Directions direction);

}
