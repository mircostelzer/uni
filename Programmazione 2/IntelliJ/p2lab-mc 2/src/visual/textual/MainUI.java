package visual.textual;

import utils.BlockErrorException;
import utils.MapCoordinates;
import data.BlockFactory;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;

public class MainUI {
    private Map m ;
    private Furnace f;
    private Inventory i;
    private BlockFactory bf;

    public MainUI(){
        this(true);
    }
    public MainUI(boolean random){
        bf = new BlockFactory();
        m = new Map(bf,random);
        f = new Furnace(bf);
        i = new Inventory(bf);
    }

    public void display_on_out(){
        print_headerfooter();
        print_map_columns();
        m.display_on_out();
        print_separator();
        f.display_on_out();
        print_separator();
        i.display_to_out();
        print_separator();
        print_headerfooter();
    }

    private static void print_headerfooter() {
        for (int i = 0; i < MapCoordinates.DIMENSION_COLUMNS+4 ; i ++ ){
            System.out.print("_");
        }
        System.out.println();
    }
    private static void print_separator() {
        System.out.print("|");
        for (int i = 0; i < MapCoordinates.DIMENSION_COLUMNS+2 ; i ++ ){
            System.out.print("=");
        }
        System.out.print("|");
        System.out.println();
    }
    private static void print_map_columns(){
        System.out.print("||");
        for (int i = 0; i < MapCoordinates.DIMENSION_COLUMNS ; i++){
            System.out.print(i);
        }
        System.out.print("||");
        System.out.println();
    }

    public void change_cell_with_Sand(MapCoordinates c){
        m.change_cell_with_Sand(c);
    }

    public void smelt(){
        Block b = f.smelt();
        i.add_block(b);
    }
    public void move_into_furnace_from_map(MapCoordinates c){
        if (!c.is_inbound()){
            return;
        }
        try {
            SmeltableBlock sb = m.gimme_smeltable(c);
            f.setInput(sb);
        } catch (BlockErrorException e) {
            System.out.println("Selection is not smeltable");
//            e.printStackTrace();
        }

    }
    public void move_into_furnace_from_inventory(int index){
        try{
            SmeltableBlock sb = i.get_smeltable_item(index);
            f.setInput(sb);
        }catch (BlockErrorException e){
            System.out.println("Selection is not smeltable");
        }
    }
    public void move_into_inventory_from_furnace(){
        i.add_block(f.getInput());
    }

    public void pick_up_block(MapCoordinates c){
        try{
            Block b = m.gimme_pickable(c);
            i.add_block(b);
        }catch (BlockErrorException e) {
            System.out.println("Selection is not pickable");
//            e.printStackTrace();
        }
    }

    public void toggle_inventory_comparator(){
        i.toggleComparator();
    }

    public Map getMap(){
        return this.m;
    }
    public Inventory getInventory() {
        return this.i;
    }
    public Furnace getFurnace(){
        return this.f;
    }
}
