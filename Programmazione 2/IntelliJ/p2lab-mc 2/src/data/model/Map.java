package data.model;

import data.BlockFactory;
import data.blocks.AbstractBlock;
import data.blocks.NullBlock;
import data.blocks.SandBlock;
import data.blocks.WaterBlock;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import data.blocks.solids.RawIronBlock;
import utils.BlockErrorException;
import utils.MapCoordinates;
import view.textual.MapPrinter;

import java.util.Random;

public class Map {
    private static final int RANDOM_BLOCKS_TO_ADD = MapCoordinates.DIMENSION_COLUMNS* MapCoordinates.DIMENSION_ROWS/5;

    private Block[][] content;
    private BlockFactory bf;

    // the default map is a random one
    public Map(BlockFactory bf){
        this(bf,true);
    }

    public Map(BlockFactory bf, boolean random){
        this.bf = bf;
        content = new AbstractBlock[MapCoordinates.DIMENSION_ROWS][MapCoordinates.DIMENSION_COLUMNS];
        for (int i = 0; i < MapCoordinates.DIMENSION_ROWS; i++){
            for (int k = 0; k < MapCoordinates.DIMENSION_COLUMNS; k++){
                Block b = bf.default_block();
                MapCoordinates c = new MapCoordinates(i,k);
                this.insert_block_at_coords(b,c,false);
            }
        }
        this.add_sea();
        if (random) {
            this.add_randomBlocks();
        }
    }
    private Block getBlock(MapCoordinates c){
        if (!c.is_inbound()){
            return bf.nullBlock();
        }
        int row = c.getRow();
        int col = c.getCol();
        return this.content[row][col];
    }
    private void setBlock(MapCoordinates c, Block b){
        if (!c.is_inbound()){
            return;
        }
        int row = c.getRow();
        int col = c.getCol();
        this.content[row][col] = b;
    }

    private void insert_block_at_coords(Block b, MapCoordinates c, boolean consider_stackeble){
        if (!c.is_inbound()){
            return;
        }
        int row = c.getRow();
        int col = c.getCol();
        this.content[row][col] = b;
        if (consider_stackeble) {
            this.move(c);
        }
    }

    private void move(MapCoordinates c){
        move_rec(c);
//        move_iter_for(c);
//        move_iter_while(c);
        // until row is less than row
        // if the row-col falls with gravity
        // and the row+1-col is fall through
        // swap row-col and row+1-col
    }
    private void move_rec(MapCoordinates c){
        int row = c.getRow();
        int col = c.getCol();
        if (row == MapCoordinates.DIMENSION_ROWS-1){
            return;
        }
        if (!this.content[row][col].isFalls_with_gravity()){
            return;
        }
        if (!this.content[row+1][col].isFall_through()){
            return;
        }
        this.swap(c);
        MapCoordinates cc = new MapCoordinates(c.getRow()+1,c.getCol());
        this.move_rec(cc);
    }
    private void move_iter_for(MapCoordinates c){
        int row = c.getRow();
        int col = c.getCol();
        if (!this.content[row][col].isFalls_with_gravity()){
            return;
        }
        for (int i = row; i < MapCoordinates.DIMENSION_ROWS-1 ; i++){
            if (!this.content[i+1][col].isFall_through()){
                break;
            }
            MapCoordinates cc = new MapCoordinates(i,c.getCol());
            this.swap(cc);
        }
    }
    private void move_iter_while(MapCoordinates c){
        int row = c.getRow();
        int col = c.getCol();

        int indx = row;
        while (this.content[indx][col].isFalls_with_gravity()
                && indx+1 < MapCoordinates.DIMENSION_ROWS
                && this.content[indx+1][col].isFall_through()){
            MapCoordinates cc = new MapCoordinates(indx, c.getCol());
            this.swap(cc);
            indx++;
        }
    }
    // precondition: row and col are valid, and so are for the next
    private void swap(MapCoordinates c){
        if (!c.is_inbound()){
            return;
        }
        int row = c.getRow();
        int col = c.getCol();
        Block b = this.getBlock(c);
        this.setBlock(c,b);
        this.setBlock(c,this.content[row+1][col]);
        this.content[row+1][col] = b;
    }

    public void change_cell_with_Sand(MapCoordinates c){
        if (!c.is_inbound()){
            return;
        }
        SandBlock b = bf.sand_block();
        this.insert_block_at_coords(b,c,true);
    }
    public void change_cell_with_random(MapCoordinates c){
        if (!c.is_inbound()){
            return;
        }
        Block b = bf.truly_random_block();
        this.insert_block_at_coords(b,c,true);
    }

    public void add_sea(){
        this.add_river();
        this.add_river();
    }
    public void add_river(){
        this.add_rows_of_water();
    }
    private void add_rows_of_water(){
        for (int k = 0; k < MapCoordinates.DIMENSION_COLUMNS ; k ++){
            Block b = bf.waterBlock();
            // basta aggiungere alla top row, l'acqua poi cade
            MapCoordinates c = new MapCoordinates(0,k);
            this.insert_block_at_coords(b, c,true);
        }
    }
    private void add_randomBlocks(){
        Random rand = new Random();
        for (int i = 0 ; i < RANDOM_BLOCKS_TO_ADD; i++){
            Block b = bf.random_block();
            int row = rand.nextInt(MapCoordinates.DIMENSION_ROWS);
            int col = rand.nextInt(MapCoordinates.DIMENSION_COLUMNS);
            if (this.sanityCheck(b, row, col)) {
                MapCoordinates c = new MapCoordinates(row,col);
                this.insert_block_at_coords(b, c, true);
            }
        }
    }
    private boolean sanityCheck(Block b, int row, int col){
        if (b instanceof RawIronBlock){
            if (this.content[row][col] instanceof WaterBlock){
                return false;
            }
        }
        return true;
    }

    private boolean is_smeltable(MapCoordinates c){
        Block b = this.getBlock(c);
        if (b instanceof NullBlock){
            return false;
        }
        return b instanceof SmeltableBlock;
    }
    public SmeltableBlock gimme_smeltable(MapCoordinates c) throws BlockErrorException {
        if (this.is_smeltable(c)){
            SmeltableBlock bb = (SmeltableBlock) this.getBlock(c);
            this.setBlock(c, bf.default_block());
            return bb;
        }else {
            throw new BlockErrorException();
        }
    }

    private boolean is_pickable(MapCoordinates c){
        Block b = this.getBlock(c);
        return b.isPickable();
    }
    public Block gimme_pickable(MapCoordinates c) throws BlockErrorException{
        if (this.is_pickable(c)){
            Block b = this.getBlock(c);
            this.setBlock(c, bf.default_block());
            return b;
        }else {
            throw new BlockErrorException();
        }
    }

    public Block getCell(MapCoordinates c){
        return this.getBlock(c);
    }

    public Block[][] getContent() {
        return content;
    }
}
