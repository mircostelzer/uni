package data.model;

import controller.textual.TextFurnaceController;
import controller.textual.TextInventoryController;
import controller.textual.TextMapController;
import data.BlockFactory;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import utils.BlockErrorException;
import utils.MapCoordinates;

public class MainFunctionalities {
    private Map m ;
    private Furnace f;
    private Inventory i;
    private BlockFactory bf;

    public MainFunctionalities(){
        this(false);
    }

    public MainFunctionalities(boolean random){
        bf = new BlockFactory();
        m = new Map(bf);
        f = new Furnace(bf);
        i = new Inventory(bf);
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

    public void change_cell_with_Sand(MapCoordinates c){
        m.change_cell_with_Sand(c);
    }
    public void add_random_block_at_coords(MapCoordinates c){
        m.change_cell_with_random(c);
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
        i.add_block(f.removeInput());
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

}
