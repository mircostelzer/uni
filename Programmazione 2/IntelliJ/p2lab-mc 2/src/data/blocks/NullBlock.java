package data.blocks;

import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import data.blocks.solids.AbstractSolidBlock;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock {
    public NullBlock(){
        super();
        this.content = ' ';
        this.blockname = " null ";
        this.pickable = false;
    }

    public Block smelt() {
        return new NullBlock();
    }
}
