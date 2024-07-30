package utils;

import java.util.Random;

public class MapCoordinates {
    public static final int DIMENSION_COLUMNS = 9;
    public static final int DIMENSION_ROWS = 5;

    private int row;
    private int col;

    public MapCoordinates(int r, int c){
        this.row = r;
        this.col = c;
    }

    public boolean is_inbound(){
        return this.row < DIMENSION_ROWS && this.col < DIMENSION_COLUMNS;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public String toString(){
        return "("+this.row+"-"+this.col+")";
    }

    public static MapCoordinates randomCoords() {
        Random rand = new Random();
        int r = rand.nextInt(DIMENSION_ROWS);
        int c = rand.nextInt(DIMENSION_COLUMNS);
        return new MapCoordinates(r,c);
    }
}
