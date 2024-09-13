package data.blocks.utils;

import data.blocks.interfaces.Block;

import java.util.Comparator;

public class AlphabeticalBlockComparator implements Comparator<Block> {
    public int compare(Block b1, Block b2) {
        return (b1.toString().compareTo(b2.toString()));
    }
}
