package data.blocks.solids;

import data.BlockFactory;
import data.blocks.interfaces.Block;

public class AbstractMineableBlock extends AbstractSolidBlock {
    protected int mineValue;

    public AbstractMineableBlock() {
        super();
    }

    public Block mine(int n) {
        this.mineValue -= n;
        if (this.mineValue <= 0) {
            return this;
        }
        else {
            return new BlockFactory().nullBlock();
        }
    }

    public int getMineValue() {
        return this.mineValue;
    }
}
