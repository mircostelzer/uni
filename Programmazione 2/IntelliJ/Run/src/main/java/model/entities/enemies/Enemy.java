package model.entities.enemies;

import model.entities.NonPlayerEntity;
import javafx.scene.shape.Shape;
import model.Player;

public abstract class Enemy extends NonPlayerEntity {
    protected Shape shape;

    public abstract void hit(Player player);
}
