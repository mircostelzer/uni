package sampleFX;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class Playground extends GridPane {
    private Grid grid;
    private Controller controller;

    public Playground(Grid grid, Controller controller) {
        this.grid = grid;
        this.controller = controller;
        this.setPrefWidth(Cell.DIM*3);
        this.setAlignment(Pos.CENTER);
        redraw();
    }

    public void redraw() {
        this.getChildren().clear();
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                this.add(new Cell(grid.getCell(i, j), i, j, controller), j, i);
            }
        }
    }

    public Grid getGrid() {
        return grid;
    }

}
