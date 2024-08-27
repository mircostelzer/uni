package model.entities.enemies;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.Player;

public class Penalty extends Enemy {
    public static final int DIM = 10;
    private final Color COLOR = Color.BLUE;

    public Penalty(int x, int y){
        this.shape = new Circle(x, y, DIM);
        this.shape.setFill(COLOR);
    }
    @Override
    public void hit(Player player) {
        this.shape.setFill(Color.TRANSPARENT);
        this.shape.setStroke(COLOR);
        player.setPoints(player.getPoints() - 500);
    }

    public Circle getShape() {
        return (Circle) this.shape;
    }
}
