package sampleFX;

import javafx.scene.layout.GridPane;

public class Playground extends GridPane {
    private Grid grid;

    public Playground() {
        this.grid = new Grid();
        this.setPrefWidth(Cell.DIM*3);
        redraw();
    }

    public void redraw() {
        this.getChildren().clear();
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                this.getChildren().add(new Cell(grid.getCell(i, j)));
            }
        }
    }
}
