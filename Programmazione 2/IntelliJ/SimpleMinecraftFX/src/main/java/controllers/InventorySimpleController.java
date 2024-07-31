package controllers;

import data.blocks.interfaces.Block;
import data.blocks.utils.AlphabeticalBlockComparator;
import data.blocks.utils.BlockComparator;
import visual.GUI.InventoryBlockPane;
import visual.GUI.InventoryPane;
import visual.textual.Inventory;

import java.util.Comparator;
import java.util.ListIterator;

public class InventorySimpleController implements SimpleController {
    private Inventory inventory;
    private InventoryPane inventoryPane;
    private MainControllerInterface mainController;

    public InventorySimpleController(Inventory inventory, InventoryPane inventoryPane, MainControllerInterface mainController) {
        this.inventory = inventory;
        this.inventoryPane = inventoryPane;
        this.mainController = mainController;
        this.redraw();
    }
    @Override
    public void redraw() {
        this.inventoryPane.getChildren().clear();
        String t = null;
        Comparator<Block> cmp = this.inventory.getComparator();
        if (cmp instanceof BlockComparator) {
            t = "t";
        }
        else if (cmp instanceof AlphabeticalBlockComparator) {
            t = "a";
        }
        this.inventoryPane.initialise(t);
        ListIterator<Block> it = this.inventory.getIterator();
        int count = 0;
        while (it.hasNext()) {
            InventoryBlockPane bp = new InventoryBlockPane(it.next(), mainController, count);
            count++;
            this.inventoryPane.getChildren().add(bp);
        }
    }
}
