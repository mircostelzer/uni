package model.tiles;

import javafx.scene.paint.Color;
import model.AbstractTile;
import model.MultiColorTileInterface;

public class P3Tile extends AbstractTile implements MultiColorTileInterface {

    public P3Tile(Color color) {
        super(color);
        this.code = "P3";
        this.material = "Terracotta";
        this.price = 50.0;
        this.dimension = 40.0;
        this.color = Color.BROWN;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
