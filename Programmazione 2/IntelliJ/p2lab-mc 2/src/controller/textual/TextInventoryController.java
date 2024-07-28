package controller.textual;

import data.BlockFactory;
import data.blocks.NullBlock;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import data.blocks.utils.AlphabeticalBlockComparator;
import data.blocks.utils.BlockComparator;
import data.model.Inventory;
import utils.BlockErrorException;
import view.textual.InventoryPrinter;

public class TextInventoryController extends AbstractTextController {
    Inventory i;

    TextInventoryController(Inventory i){
        this.i = i;
        tp = new InventoryPrinter();
    }

    void updatePrinter() {
        ((InventoryPrinter) tp).update(i.get_inventory(),i.get_comparator());
    }

}
