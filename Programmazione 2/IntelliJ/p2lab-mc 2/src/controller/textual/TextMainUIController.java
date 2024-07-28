package controller.textual;

import data.model.Furnace;
import data.model.Inventory;
import data.model.MainFunctionalities;
import data.model.Map;
import utils.BlockErrorException;
import utils.MapCoordinates;
import data.BlockFactory;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import view.textual.FurnacePrinter;
import view.textual.InventoryPrinter;
import view.textual.MainPrinter;
import view.textual.MapPrinter;

public class TextMainUIController extends AbstractTextController{
    private TextMapController m ;
    private TextFurnaceController f;
    private TextInventoryController i;

    private MainFunctionalities mf;

    public TextMainUIController(){
        this(true);
    }
    public TextMainUIController(boolean random){
        mf = new MainFunctionalities(random);

        tp = new MainPrinter();
        m = new TextMapController(mf.getMap());
        f = new TextFurnaceController(mf.getFurnace());
        i = new TextInventoryController(mf.getInventory());
    }

    public void updatePrinter(){
        m.updatePrinter();
        f.updatePrinter();
        i.updatePrinter();
        ((MainPrinter)tp).update((MapPrinter) m.getPrinter(), (FurnacePrinter) f.getPrinter(), (InventoryPrinter) i.getPrinter());
    }

    public void smelt() {
        this.mf.smelt();
    }
    public void move_into_inventory_from_furnace() {
        this.mf.move_into_inventory_from_furnace();
    }
    public void move_into_furnace_from_inventory(int index) {
        this.mf.move_into_furnace_from_inventory(index);
    }
    public void pick_up_block(MapCoordinates c) {
        this.mf.pick_up_block(c);
    }
    public void toggle_inventory_comparator() {
        this.mf.toggle_inventory_comparator();
    }
    public void add_random_block_at_coords(MapCoordinates c) {
        this.mf.add_random_block_at_coords(c);
    }
    public void change_cell_with_Sand(MapCoordinates c) {
        this.mf.change_cell_with_Sand(c);
    }
    public void move_into_furnace_from_map(MapCoordinates c) {
        this.mf.move_into_furnace_from_map(c);
    }
}
