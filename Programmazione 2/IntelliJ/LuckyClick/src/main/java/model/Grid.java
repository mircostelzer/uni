package model;

import model.cells.*;

import java.util.Random;

public class Grid {
    private AbstractCell[][] grid;
    private Player player;

    public Grid(Player p) {
        grid = new AbstractCell[10][10];
        this.player = p;
        this.addRandomCells(5, new BombCell());
        this.addRandomCells(10, new MultiplierCell());
        this.addRandomCells(10, new DividerCell());
        this.addRandomCells(75, new BaseCell(0));
    }

    private void addRandomCells(int n, AbstractCell c) {
        for (int i = 0; i < n; i++) {
            Random rand = new Random();
            int row = rand.nextInt(10);
            int col = rand.nextInt(10);
            if (grid[row][col] == null) {
                if (c instanceof BombCell) {
                    grid[row][col] = new BombCell();
                } else if (c instanceof MultiplierCell) {
                    grid[row][col] = new MultiplierCell();
                } else if (c instanceof DividerCell) {
                    grid[row][col] = new DividerCell();
                } else if (c instanceof BaseCell) {
                    int val = rand.nextInt(10)*1000;
                    grid[row][col] = new BaseCell(val);
                }
            }
            else {
                i--;
            }
        }
    }

    public void reveal(int x, int y) {
        if (grid[x][y].isActive()) {
            return;
        }
        if (grid[x][y] instanceof BaseCell) {
            player.applyModifier(((BaseCell) grid[x][y]).reveal());
        } else if (grid[x][y] instanceof MultiplierCell) {
            player.applyModifier(((MultiplierCell) grid[x][y]).reveal());
        } else if (grid[x][y] instanceof DividerCell) {
            player.applyModifier(((DividerCell) grid[x][y]).reveal());
        } else if (grid[x][y] instanceof BombCell) {
            grid[x][y].setActive(true);
            for (int i=0; i<10; i++) {
                this.reveal(x, i);
                this.reveal(i, y);
            }
        }
    }

    public AbstractCell getCellAtCoords(int x, int y) {
        return grid[x][y];
    }
}
