package model;


import javafx.scene.paint.Color;
import model.tiles.TileInterface;

public abstract class AbstractTile implements TileInterface {
    protected String code;
    protected String material;
    protected double price;
    protected double dimension;
    protected Color color;

    public AbstractTile(Color color) {
        this.color = color;
    }

    public String getCode() {
        return code;
    }

    public String getMaterial() {
        return material;
    }

    public double getPrice() {
        return price;
    }

    public double getDimension() {
        return dimension;
    }

    public Color getColor() {
        return color;
    }

}
