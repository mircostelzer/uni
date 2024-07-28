package data.model;

import data.BlockFactory;
import data.blocks.NullBlock;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import data.blocks.utils.AlphabeticalBlockComparator;
import data.blocks.utils.BlockComparator;
import utils.BlockErrorException;
import view.textual.InventoryPrinter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class Inventory {
    private Collection<Block> inventory_list;
    private BlockFactory bf;
    private Comparator<Block> cb;

    public Inventory(BlockFactory b){
        this.bf = b;
        inventory_list = new ArrayList<Block>();
        cb = new BlockComparator();
    }

    public void add_block(Block b){
        if (!(b instanceof NullBlock)) {
            this.inventory_list.add(b);
            this.sort_inventory();
        }
    }
    public Block get_item(int index) throws IndexOutOfBoundsException{
        if (this.has_index(index)) {
            return ((ArrayList<Block>) this.inventory_list).remove(index);
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    private boolean has_index(int index){
        return index < this.inventory_list.size();
    }
    private boolean is_smeltable(int index) throws IndexOutOfBoundsException{
        Block b = ((ArrayList<Block>) this.inventory_list).get(index);
        return b instanceof SmeltableBlock;
    }
    public SmeltableBlock get_smeltable_item(int index) throws BlockErrorException {
        if (this.is_smeltable(index)){
            return (SmeltableBlock) ((ArrayList<Block>) this.inventory_list).remove(index);
        }else{
            throw new BlockErrorException();
        }
    }

    private void sort_inventory(){
        ((ArrayList<Block>) this.inventory_list).sort(cb);
    }
    public void toggleComparator(){
        if (cb instanceof BlockComparator){
            cb = new AlphabeticalBlockComparator();
        }else if (cb instanceof AlphabeticalBlockComparator){
            cb = new BlockComparator();
        }
        this.sort_inventory();
    }

    public Iterator<Block> get_inventory(){
        return this.inventory_list.iterator();
    }
    public Comparator<Block> get_comparator(){
        return this.cb;
    }

}
