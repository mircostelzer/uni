package visual.printer;

import data.blocks.interfaces.Block;

public class MapPrinter implements TextPrinter {
    private Block[][] grid;
    private int rows;
    private int columns;

    public MapPrinter() {}

    public void display_on_out() {
        System.out.print("  ");
        for (int i = 0; i< columns; i++) {
            System.out.print("=");
        }
        System.out.println();
        for (int i = 0; i< rows; i++) {
            System.out.print("||");
            for (int j = 0; j< columns; j++) {
                System.out.print(grid[i][j].display());
            }
            System.out.print("||");
            System.out.println();
        }
        System.out.print("  ");
        for (int i = 0; i< columns; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    public void update(Block[][] grid, int rows, int columns) {
        this.grid = grid;
        this.rows = rows;
        this.columns = columns;
    }
}
