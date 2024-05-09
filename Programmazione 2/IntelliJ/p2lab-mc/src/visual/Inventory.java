package visual;

import data.BlockFactory;
import data.blocks.NullBlock;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import data.blocks.utils.AlphabeticalBlockComparator;
import data.blocks.utils.BlockComparator;
import utils.BlockErrorException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

class Inventory {
    private Collection<Block> inventory_list;
    private BlockFactory bf;
    private Comparator<Block> cb;

    Inventory(BlockFactory b){
        this.bf = b;
        inventory_list = new ArrayList<Block>();
        cb = new BlockComparator();
    }

    public void display_to_out(){
        display_comparator();
        System.out.print("|");
        Iterator<Block> iterator = inventory_list.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next().display_in_inventory());
        }
        System.out.println("|");
    }
    private void display_comparator(){
        if (cb instanceof BlockComparator){
            System.out.print("t");
        }else if (cb instanceof AlphabeticalBlockComparator){
            System.out.print("a");
        }
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
    public SmeltableBlock get_smeltable_item(int index) throws BlockErrorException{
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
    }
}
