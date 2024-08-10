package model.tiles;

import javafx.scene.paint.Color;
import model.BiColorTile;
import model.MultiBiColorInterface;

public class B2Tile extends BiColorTile implements MultiBiColorInterface {

    public B2Tile() {
        this.code = "B2";
        this.material = "Ceramica";
        this.price = 120.0;
        this.dimension = 90.0;
        this.shape = "Circle";
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
