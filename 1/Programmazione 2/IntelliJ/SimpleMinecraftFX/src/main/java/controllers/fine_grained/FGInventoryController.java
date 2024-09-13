package controllers.fine_grained;

import controllers.MainControllerInterface;
import data.blocks.interfaces.Block;
import data.blocks.utils.AlphabeticalBlockComparator;
import data.blocks.utils.BlockComparator;
import visual.GUI.InventoryBlockPane;
import visual.GUI.InventoryPane;
import visual.textual.Inventory;

import java.util.Collection;
import java.util.Comparator;
import java.util.ListIterator;

public class FGInventoryController extends AbstractFGController {
    private Inventory inventory;
    private InventoryPane inventoryPane;
    private MainControllerInterface mainController;

    public FGInventoryController(Inventory inventory, InventoryPane inventoryPane, MainControllerInterface mainController) {
        super();
        this.inventory = inventory;
        this.inventoryPane = inventoryPane;
        this.mainController = mainController;
        this.redraw();
    }

    @Override
    public void efficient_redraw() {
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

    @Override
    public void not_efficient_redraw() {
        this.efficient_redraw();
    }

    public void add_efficiency_enabler(Object o) {
        return;
    }
}
