package controller.textual;

import data.model.Inventory;
import view.textual.InventoryPrinter;

public class TextInventoryController extends AbstractTextController {
    Inventory i;

    TextInventoryController(Inventory i){
        this.i = i;
        tp = new InventoryPrinter();
    }

    public void updatePrinter() {
        ((InventoryPrinter) tp).update(i.get_inventory(),i.get_comparator());
    }

}
