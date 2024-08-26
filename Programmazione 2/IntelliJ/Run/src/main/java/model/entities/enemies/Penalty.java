package model.entities.enemies;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.Player;

public class Penalty extends Enemy {
    private final int DIM = 10;
    private final Color COLOR = Color.BLUE;

    public Penalty(int x, int y){
        this.shape = new Circle(x, y, DIM);

    }
    @Override
    public void hit(Player player) {
        this.shape.setFill(Color.TRANSPARENT);
        this.shape.setStroke(COLOR);
        player.setPoints(player.getPoints() - 500);
    }
}
