package model.tiles;

import javafx.scene.paint.Color;
import model.AbstractTile;
import model.MultiColorTileInterface;

public class P2Tile extends AbstractTile implements MultiColorTileInterface {

    public P2Tile(Color color) {
        super(color);
        this.code = "P2";
        this.material = "Laminato";
        this.price = 20.0;
        this.dimension = 80.0;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
