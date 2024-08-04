package sampleFX;

public class Controller {
    private Grid grid;
    private Playground playground;

    public Controller(Grid grid) {
        this.playground = new Playground(grid, this);
        this.grid = playground.getGrid();
    }

    public void move(int x, int y, String s) {
        this.grid.move(x, y, s);
        this.playground.redraw();
    }

    public void computer() {
        this.grid.computer();
        this.playground.redraw();
    }

    public boolean isGameOver() {
        return this.grid.isGameOver();
    }

    public Playground getPlayground() {
        return this.playground;
    }

}
