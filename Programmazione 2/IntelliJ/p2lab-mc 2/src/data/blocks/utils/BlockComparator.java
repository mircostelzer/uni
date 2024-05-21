package data.blocks.utils;

import data.blocks.AirBlock;
import data.blocks.NullBlock;
import data.blocks.SandBlock;
import data.blocks.WaterBlock;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.IronSwordInterfaceBlock;
import data.blocks.solids.EarthBlock;
import data.blocks.solids.GlassBlock;
import data.blocks.solids.RawIronBlock;

import java.util.Comparator;

public class BlockComparator implements Comparator<Block> {
    public int compare(Block o1, Block o2) {
        return Integer.compare(BlockComparator.get_value_of_block(o1),BlockComparator.get_value_of_block(o2));
    }

    public static int get_value_of_block(Block b){
        if (b instanceof NullBlock){
            return 0;
        }
        if (b instanceof AirBlock){
            return 1;
        }
        if (b instanceof WaterBlock){
            return 2;
        }
        if (b instanceof EarthBlock){
            return 3;
        }
        if (b instanceof SandBlock){
            return 4;
        }
        if (b instanceof GlassBlock){
            return 5;
        }
        if (b instanceof RawIronBlock){
            return 6;
        }
        if (b instanceof IronSwordInterfaceBlock){
            return 7;
        }
        return 100;
    }
}
