package controllers;

import data.blocks.interfaces.Block;
import data.blocks.utils.AlphabeticalBlockComparator;
import data.blocks.utils.BlockComparator;
import visual.GUI.InventoryPane;
import visual.textual.Inventory;

import java.util.Comparator;
import java.util.ListIterator;

public class InventorySimpleController implements SimpleController {
    private Inventory inventory;
    private InventoryPane inventoryPane;

    public InventorySimpleController(Inventory inventory, InventoryPane inventoryPane) {
        this.inventory = inventory;
        this.inventoryPane = inventoryPane;
        this.redraw();
    }
    @Override
    public void redraw() {
        this.inventoryPane.getChildren().clear();
        this.inventoryPane.initialise();
        String t = null;
        Comparator<Block> cmp = this.inventory.getComparator();
        if (cmp instanceof BlockComparator) {
            t = "t";
        }
        else if (cmp instanceof AlphabeticalBlockComparator) {
            t = "a";
        }
        this.inventoryPane.addInventoryText(t);
        ListIterator<Block> it = this.inventory.getIterator();
        while (it.hasNext()) {
            this.inventoryPane.addBlock(it.next());
        }
    }
}
