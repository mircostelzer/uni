package model;

import javafx.scene.paint.Color;
import model.tiles.TileInterface;

public interface MultiBiColorInterface extends MultiColorTileInterface {
    void setSecondColor(Color color);
}
