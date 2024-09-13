package model.tiles;

import javafx.scene.paint.Color;
import model.AbstractTile;


public class P1Tile extends AbstractTile {

    public P1Tile(Color color) {
        super(color);
        this.code = "P1";
        this.material = "Ceramica";
        this.price = 50.0;
        this.dimension = 50.0;

    }
}
