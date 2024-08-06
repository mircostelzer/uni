package view;

import controller.Controller;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.Grid;
import model.cells.AbstractCell;

public class PlayGridPane extends GridPane {
    private Grid grid;
    private Controller controller;

    public PlayGridPane(Grid grid, Controller controller) {
        this.grid = grid;
        this.controller = controller;
        this.redraw();
        this.setAlignment(Pos.CENTER);
    }

    public void redraw() {
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                AbstractCell c = grid.getCellAtCoords(i, j);
                this.setCell(c, i, j);
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
            super.add(new CellPane(cell, this.controller), y, x);
        }

    }
}
