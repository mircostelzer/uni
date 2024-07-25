package Controllers;

import data.blocks.interfaces.Block;
import visual.GUI.InventoryPane;
import visual.textual.Inventory;

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
        ListIterator<Block> it = this.inventory.getIterator();
        while (it.hasNext()) {
            this.inventoryPane.addBlock(it.next());
        }
    }
}
