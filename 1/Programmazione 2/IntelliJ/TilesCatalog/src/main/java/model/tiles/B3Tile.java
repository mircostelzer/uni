package model.tiles;

import javafx.scene.paint.Color;
import model.BiColorTile;
import model.MultiBiColorInterface;

public class B3Tile extends BiColorTile implements MultiBiColorInterface {

    public B3Tile(Color firstColor, Color secondColor) {
        super(firstColor, secondColor);
        this.code = "B3";
        this.material = "Terracotta";
        this.price = 140.0;
        this.dimension = 50.0;
        this.shape = "Rectangle";
    }

    @Override
    public void setSecondColor(Color color) {
        this.secondColor = color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
