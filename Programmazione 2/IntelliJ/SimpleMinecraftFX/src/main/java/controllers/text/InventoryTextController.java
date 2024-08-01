package controllers.text;

import visual.printer.InventoryPrinter;
import visual.textual.Inventory;

public class InventoryTextController extends AbstractTextController {
    private Inventory inventory;

    public InventoryTextController(Inventory inventory) {
        this.inventory = inventory;
        this.tp = new InventoryPrinter();
    }

    @Override
    public void updatePrinter() {
        ((InventoryPrinter)this.tp).update(inventory.getIterator(), inventory.getComparator());
    }
}
