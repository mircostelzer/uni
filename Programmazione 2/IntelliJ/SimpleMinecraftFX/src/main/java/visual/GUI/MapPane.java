package visual.GUI;

import Utils.Coordinates;
import data.BlockFactory;
import data.blocks.interfaces.Block;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import visual.textual.Map;

public class MapPane extends GridPane {

    public MapPane() {
        super();
        this.setAlignment(Pos.CENTER);
        this.initialise_air();
    }

    public void initialise_air() {
        for (int i=0; i< Map.DEFAULT_ROWS; i++) {
            for (int j=0; j<Map.DEFAULT_COLUMNS; j++) {
                BlockPane bp = new BlockPane(new BlockFactory().airBlock());
                super.add(bp, j, i);
            }
        }
    }

    public static Node getElementAt(GridPane gp, int i, int j) {
        for (Node x :gp. getChildren()) {
            if ((GridPane.getRowIndex(x) == i) && (GridPane.getColumnIndex(x) == j)) {
                return x;
            }
        }
        return null;
    }

    public BlockPane get_block_at_coord(Coordinates coords) {
        int x = coords.getX();
        int y = coords.getY();
        if (x >= 0 && y >= 0 && x < Map.DEFAULT_ROWS && y < Map.DEFAULT_COLUMNS) {
            return (BlockPane) MapPane.getElementAt(this, x, y);
        }
        return null;
    }

    public void setCell(Block b, Coordinates coords) {
        BlockPane remove = this.get_block_at_coord(coords);
        if (remove != null) {
            remove.changeBlock(b);
        }
        else {
            super.add(new BlockPane(b), coords.getY(), coords.getX());
        }
    }
}
