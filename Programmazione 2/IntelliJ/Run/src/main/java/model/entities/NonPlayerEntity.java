package model.entities;

import javafx.scene.shape.Shape;

public class NonPlayerEntity implements Entity{
    protected Shape shape;
    @Override
    public void move() {
        shape.setTranslateX(shape.getTranslateX() - 10);
    }
}
