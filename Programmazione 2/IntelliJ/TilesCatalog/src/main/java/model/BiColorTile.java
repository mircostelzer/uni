package model;


import javafx.scene.paint.Color;

public abstract class BiColorTile extends AbstractTile {
    protected Color secondColor;
    protected String shape;

    public BiColorTile() {
        super();
        this.secondColor = Color.WHEAT;
    }

    public Color getSecondColor() {
        return secondColor;
    }

    public String getShape() {
        return shape;
    }
}
