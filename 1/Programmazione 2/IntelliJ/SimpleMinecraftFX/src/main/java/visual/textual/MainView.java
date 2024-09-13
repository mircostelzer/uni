package visual.textual;

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

    public void smelt() {
        Block b = this.furnace.smelt();
        this.inventory.add_block(b);
    }

    public void move_into_furnace_from_inventory(int i) throws BlockErrorException {
            SmeltableBlock b = this.inventory.get_smeltable_item(i);
            this.furnace.setInput(b);
    }

    public void move_into_inventory_from_furnace() {
        Block b = this.furnace.getInput();
        this.inventory.add_block(b);
        SmeltableBlock nullBlock = this.bf.nullBlock();
        this.furnace.setInput(nullBlock);
    }

    public void pick_up_block(Coordinates coords) throws BlockErrorException, WrongCoordinatesException {
            Block pick_up = this.map.gimme_pickable(coords);
            if (!(pick_up instanceof NullBlock)) {
                this.inventory.add_block(pick_up);
            }
    }

    public void toggle_inventory_comparator() {
        this.inventory.switch_comparator();
    }

    public void add_random_blocks(int n) {
        this.map.addRandomBlocks(n);
    }

    public void mine(int n, Coordinates coords) throws WrongCoordinatesException, BlockErrorException {
        Block b = this.map.mine(n, coords);
        if (!(b instanceof NullBlock)) {
            b = this.map.gimme_pickable(coords);
            this.inventory.add_block(b);
        }
    }

    public Map getMap() {
        return map;
    }

    public Furnace getFurnace() {
        return furnace;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
