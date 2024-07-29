package visual.textual;

import Utils.BlockErrorException;
import Utils.Coordinates;
import Utils.WrongCoordinatesException;
import data.BlockFactory;
import data.blocks.*;
import data.blocks.interfaces.Block;
import data.blocks.solids.RawIronBlock;
import data.blocks.solids.TorchBlock;

import java.util.Random;

public class Map {

    private static int rows;
    private static int columns;

    public static final int DEFAULT_ROWS = 10;
    public static final int DEFAULT_COLUMNS = 10;

    private Block[][] grid;
    private BlockFactory bf;

    public Map() {
        this.bf = new BlockFactory();
        rows = Map.DEFAULT_ROWS;
        columns = Map.DEFAULT_COLUMNS;

        this.grid = new AbstractBlock[rows][columns];
        for (int i = 0; i< rows; i++) {
            for (int j = 0; j< columns; j++) {
                Block b = this.bf.airBlock();
                Coordinates coords = new Coordinates(i, j);
                this.insert_at_coords(b, coords);
            }
        }

        this.addRiver();
        this.addRandomBlocks(rows * columns/5);
    }

    public Map(int r, int c) {
        rows = r;
        columns = c;
        this.bf = new BlockFactory();
        this.grid = new AbstractBlock[rows][columns];
        for (int i = 0; i< rows; i++) {
            for (int j = 0; j< columns; j++) {
                Block b = this.bf.airBlock();
                Coordinates coords = new Coordinates(i, j);
                this.insert_at_coords(b, coords);
            }
        }

        this.addSea();
        this.addRandomBlocks(rows * columns/5);
    }

    public Block[][] getGrid() {
        return this.grid;
    }

    public boolean checkCoordinates(Coordinates coords) {
        return (coords.getX() >= 0 && coords.getX() < rows) &&
                (coords.getY() >= 0 && coords.getY() < columns);
    }

//    public void change_cell_with_Sand(Coordinates coords) {
//        if (checkCoordinates(coords)) {
//            this.grid[coords.getX()][coords.getY()] = new SandBlock();
//        }
//        else {
//            System.out.println("Invalid coordinates");
//        }
//    }

    public Block getBlock(Coordinates coords) throws WrongCoordinatesException {
        if (this.checkCoordinates(coords)) {
            return grid[coords.getX()][coords.getY()];
        }
        else {
            throw new WrongCoordinatesException();
        }
    }

    private void setBlock(Coordinates coords, Block b) {
        if (this.checkCoordinates(coords)) {
            grid[coords.getX()][coords.getY()] = b;
        }
    }

    private void swap(Coordinates coords) {
        int x = coords.getX();
        int y = coords.getY();
        Coordinates next = coords.nextX();
        if (this.checkCoordinates(next)) {
            Block tmp = this.grid[x][y];
            this.grid[x][y] = this.grid[x+1][y];
            this.grid[x+1][y] = tmp;
        }
    }

    private void insert_at_coords(Block b, Coordinates coords) {
            this.setBlock(coords, b);
            //this.insert_iter(coords);
            insert_rec(coords);
    }

    public void insert_rec(Coordinates coords) {
        int x = coords.getX();
        int y = coords.getY();

        if (grid[x][y] instanceof SandBlock) {
            if ((x+1 < rows) && (grid[x+1][y] instanceof TorchBlock) ) {
                    this.setBlock(coords, this.bf.airBlock());
                    this.gravity(coords);
                return;
            }
        }
        if (    x >= (rows - 1)
                || !grid[x][y].getFalls_with_gravity()
                || !grid[x+1][y].getFall_through()) {
            return;
        }

        this.swap(coords);
        this.insert_rec(coords.nextX());
    }

    public void insert_iter(Coordinates coords) {
        while ( checkCoordinates(coords.nextX())
                && grid[coords.getX()][coords.getY()].getFalls_with_gravity()
                && grid[coords.nextX().getX()][coords.getY()].getFall_through()) {

            this.swap(coords);
            coords = coords.nextX();
        }
    }

    private void addRowsOfWater(int n) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<columns; j++) {
                Block w = this.bf.waterBlock();
                insert_at_coords(w, new Coordinates(0, j));
            }
        }
    }

    public void addRiver() {

        addRowsOfWater(1);
    }

    public void addSea() {

        addRowsOfWater(3);
    }

//    private boolean IsSmeltableBlock(Coordinates coords) {
//        return (checkCoordinates(coords) &&
//                grid[coords.getX()][coords.getY()] instanceof SmeltableBlock);
//    }
//
//    protected SmeltableBlock getSmeltableBlock(Coordinates coords) throws BlockErrorException {
//        if (IsSmeltableBlock(coords)) {
//            SmeltableBlock b = (SmeltableBlock)grid[coords.getX()][coords.getY()];
//            try {
//                insert_at_coords(this.bf.airBlock(), coords);
//            }
//            catch (WrongCoordinatesException e) {}
//            for (int i= coords.getX()-1; i>=0; i--) {
//                this.insert_rec(new Coordinates(i, coords.getY()));
//            }
//            return b;
//        }
//        else {
//            throw new BlockErrorException();
//        }
//    }

    public void addRandomBlocks(int n) {
        Random rand = new Random();
        for (int i=0; i<n; i++) {
            Block b = this.bf.randomBlock();
            int row = rand.nextInt(rows);
            int col = rand.nextInt(columns);
            if (this.sanity_check_water(b, row, col)) {
                this.insert_at_coords(b, new Coordinates(row, col));
                if (this.sanity_check_torch(b, row, col)) {
                    this.gravity(new Coordinates(row, col));
                }
            }
            else {
                i--;
            }
        }
    }

    private boolean sanity_check_water(Block b, int row, int col) {
        if ((b instanceof RawIronBlock) || (b instanceof TorchBlock)) {
            if (grid[row][col] instanceof WaterBlock) {
                return false;
            }
        }
        return true;
    }

    private boolean sanity_check_torch(Block b, int row, int col) {
        return ((b instanceof TorchBlock) &&
                (row-1 > 0) &&
                (grid[row-1][col] instanceof SandBlock));

    }

    public boolean is_pickable(Coordinates coords) throws WrongCoordinatesException {
        Block b = this.getBlock(coords);
        return b.is_pickable();
    }

    public Block gimme_pickable(Coordinates coords) throws BlockErrorException, WrongCoordinatesException {
            if (this.is_pickable(coords)) {
                Block b = this.getBlock(coords);
                this.setBlock(coords, this.bf.airBlock());
                this.gravity(coords);
                return b;
            }
            else {
                    throw new BlockErrorException();
                }
    }

    public void gravity(Coordinates coords) {
        for (int i= coords.getX()-1; i>=0; i--) {
            this.insert_rec(new Coordinates(i, coords.getY()));
        }
    }

}
