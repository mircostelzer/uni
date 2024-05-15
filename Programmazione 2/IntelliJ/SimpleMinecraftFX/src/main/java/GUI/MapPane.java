package GUI;

import data.blocks.AirBlock;
import data.blocks.interfaces.Block;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import visual.Map;

public class MapPane extends GridPane {

    private GridPane gp;

    public MapPane() {
        super();
        this.initialise_air();
    }

    public void initialise_air() {
        for (int i=0; i<10; i++) {
            for (int j=0; j<5; j++) {
                this.gp.add(new BlockPane(new AirBlock()), i, j);
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

    public BlockPane get_block_at_coord(int x, int y) {
        return (BlockPane) MapPane.getElementAt(this.gp, x, y);
    }

    public void setCell(Block b, int x, int y) {
        this.gp.add(new BlockPane(b), x, y);
    }
}
