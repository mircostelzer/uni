package visual.printer;

import data.blocks.interfaces.Block;
import data.blocks.utils.AlphabeticalBlockComparator;
import data.blocks.utils.BlockComparator;

import java.util.*;

public class InventoryPrinter implements TextPrinter {
    private ListIterator<Block> inventory;
    private Comparator<Block> comparator;

    public InventoryPrinter() {}

    public void display_on_out() {
        if (this.comparator instanceof BlockComparator) {
            System.out.print("t");
        }
        else if (this.comparator instanceof AlphabeticalBlockComparator) {
            System.out.print("a");
        }
        while (inventory.hasNext()) {
            Block b = inventory.next();
            System.out.print(b.display_in_inventory());
        }
        System.out.println();
    }

    public void update(ListIterator<Block> inventory, Comparator<Block> comparator) {
        this.inventory = inventory;
        this.comparator = comparator;
    }
}
