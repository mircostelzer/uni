package model;


import javafx.scene.paint.Color;

public abstract class BiColorTile extends AbstractTile {
    protected Color secondColor;
    protected String shape;

    public BiColorTile(Color firstColor, Color secondColor) {
        super(firstColor);
        this.secondColor = secondColor;
    }

    public Color getSecondColor() {
        return secondColor;
    }

    public String getShape() {
        return shape;
    }
}
