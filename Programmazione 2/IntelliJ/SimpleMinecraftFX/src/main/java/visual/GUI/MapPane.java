package visual.GUI;

import Utils.Coordinates;
import controllers.MainControllerInterface;
import controllers.MainSimpleController;
import controllers.MainVisualInterface;
import data.BlockFactory;
import data.blocks.interfaces.Block;
import data.blocks.solids.AbstractMineableBlock;
import data.blocks.solids.RawIronBlock;
import data.blocks.solids.SandBlock;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import visual.textual.Map;

public class MapPane extends GridPane {
    private MainVisualInterface mainController;

    public MapPane(MainVisualInterface mainController) {
        super();
        this.mainController = mainController;
        this.setAlignment(Pos.CENTER);
        this.initialise_air();
    }

    public void initialise_air() {
        for (int i=0; i< Map.DEFAULT_ROWS; i++) {
            for (int j=0; j<Map.DEFAULT_COLUMNS; j++) {
                MapBlockPane bp = new MapBlockPane(new BlockFactory().airBlock(), (MainVisualInterface) mainController, new Coordinates(i, j));
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

    public MapBlockPane get_block_at_coord(Coordinates coords) {
        int x = coords.getX();
        int y = coords.getY();
        if (x >= 0 && y >= 0 && x < Map.DEFAULT_ROWS && y < Map.DEFAULT_COLUMNS) {
            return (MapBlockPane) MapPane.getElementAt(this, x, y);
        }
        return null;
    }

    public void setCell(Block b, Coordinates coords) {
        MapBlockPane remove = this.get_block_at_coord(coords);
        if (remove != null) {
            remove.changeBlock(b);
        }
        else {
            MapBlockPane add = new MapBlockPane(b, (MainVisualInterface) mainController, coords);
            if (b instanceof SandBlock) {
                add.setOpacity((double) ((AbstractMineableBlock) b).getMineValue() / SandBlock.DEFAULT_MINE_VALUE);
            }
            else if (b instanceof RawIronBlock) {
                add.setOpacity((double) ((AbstractMineableBlock) b).getMineValue() / RawIronBlock.DEFAULT_MINE_VALUE);
            }
            super.add(add, coords.getY(), coords.getX());
        }
    }

}
