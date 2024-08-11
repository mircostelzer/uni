package model;


import javafx.scene.paint.Color;
import model.tiles.TileInterface;

public interface MultiColorTileInterface extends TileInterface {
    void setColor(Color color);
}
