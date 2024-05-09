package data.blocks.utils;

import data.blocks.interfaces.Block;

import java.util.Comparator;

public class AlphabeticalBlockComparator implements Comparator<Block> {
    public int compare(Block o1, Block o2) {
        return o1.toString().compareTo(o2.toString());
    }
}
