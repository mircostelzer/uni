package model.entities.enemies;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Player;

public class Block extends Enemy {
    private final int DIM = 20;
    private static final Color COLOR = Color.RED;

    public Block(int x, int y) {
        this.shape = new Rectangle(x, y, DIM, DIM);
        this.shape.setFill(COLOR);
    }
    @Override
    public void hit(Player player) {
        this.shape.setFill(Color.TRANSPARENT);
        this.shape.setStroke(COLOR);
        player.setLives(player.getLives() - 1);
    }

    public Rectangle getShape() {
        return ((Rectangle) this.shape);
    }
}
