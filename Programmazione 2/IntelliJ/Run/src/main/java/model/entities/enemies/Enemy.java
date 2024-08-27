package model.entities.enemies;

import javafx.scene.Group;
import model.entities.NonPlayerEntity;
import javafx.scene.shape.Shape;
import model.Player;

public abstract class Enemy extends NonPlayerEntity {

    public abstract void hit(Player player);
}
