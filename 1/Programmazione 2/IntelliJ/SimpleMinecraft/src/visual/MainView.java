package visual;

import Utils.BlockErrorException;
import Utils.Coordinates;
import Utils.WrongCoordinatesException;
import data.BlockFactory;
import data.blocks.NullBlock;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;

public class MainView {
    private Map map;
    private Furnace furnace;
    private BlockFactory bf;
    private Inventory inventory;

    public MainView() {
        this.map = new Map();
        this.furnace = new Furnace();
        this.bf = new BlockFactory();
        this.inventory = new Inventory();
    }

    public void display_on_out() {
        this.map.display_on_out();
        this.furnace.display_on_out();
        this.inventory.display_inventory();
    }

//    public void move_into_furnace_from_map(Coordinates coords) {
//        SmeltableBlock smeltableBlock = this.map.getSmeltableBlock(coords);
//        if (!(smeltableBlock instanceof NullBlock)) {
//            this.furnace.setInput(smeltableBlock);
//            Block b = this.bf.airBlock();
//            this.map.insert_at_coords(b, coords);
//        }
//    }

    public void smelt() {
        Block b = this.furnace.smelt();
        this.inventory.add_block(b);
    }

    public void move_into_furnace_from_inventory(int i) {
        try {
            SmeltableBlock b = this.inventory.get_smeltable_item(i);
            this.furnace.setInput(b);
        }
        catch (BlockErrorException e) {
            System.out.println("Not a smeltable block");
        }
    }

    public void move_into_inventory_from_furnace() {
        Block b = this.furnace.getInput();
        this.inventory.add_block(b);
        SmeltableBlock nullBlock = this.bf.nullBlock();
        this.furnace.setInput(nullBlock);
    }

    public void pick_up_block(Coordinates coords) {
        try {
            Block pick_up = this.map.gimme_pickable(coords);
            if (!(pick_up instanceof NullBlock)) {
                this.inventory.add_block(pick_up);
            }
        }
        catch (BlockErrorException e) {
            System.out.println("Block cannot be picked up") ;
        }
    }

    public void toggle_inventory_comparator() {
        this.inventory.switch_comparator();
    }
}
