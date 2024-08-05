package view;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Cell;
import javafx.scene.layout.GridPane;
import model.Grid;
import model.cells.AbstractCell;
import model.cells.BaseCell;

public class PlayGridPane extends GridPane {
    private Grid grid;

    public PlayGridPane(Grid grid) {
        this.grid = grid;
        this.initialise();
        this.setAlignment(Pos.CENTER);
    }

    private void initialise() {
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                AbstractCell c = grid.getCellAtCoords(i, j);

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

    public void setCell(AbstractCell cell, int x, int y) {
        CellPane remove = (CellPane) PlayGridPane.getElementAt(this, x, y);
        if (remove != null) {
            remove.setContent(cell);
        } else {
            super.add(new CellPane(cell), y, x);
        }

    }
}
