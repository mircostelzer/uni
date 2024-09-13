package model.entities;

import javafx.scene.shape.Shape;

public class NonPlayerEntity implements Entity{
    protected Shape shape;

    public Shape getShape() {
        return shape;
    }

    @Override
    public void move() {
        shape.setTranslateX(shape.getTranslateX() - 10);
    }
}
