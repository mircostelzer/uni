package view.textual;

import data.BlockFactory;
import data.blocks.interfaces.Block;
import data.blocks.utils.AlphabeticalBlockComparator;
import data.blocks.utils.BlockComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class InventoryPrinter implements TextPrinter{
    private Iterator<Block> il;
    private Comparator<Block> cb;

    public InventoryPrinter(){}

    public void update(Iterator<Block> il, Comparator<Block> cb){
        this.il = il;
        this.cb = cb;
    }

    public void display_on_out() {
        display_comparator(cb);
        System.out.print("|");

        while (il.hasNext()) {
            System.out.print(il.next().display_in_inventory());
        }
        System.out.println("|");
    }

    private void display_comparator(Comparator<Block> cb){
        if (cb instanceof BlockComparator){
            System.out.print("t");
        }else if (cb instanceof AlphabeticalBlockComparator){
            System.out.print("a");
        }
    }
}
