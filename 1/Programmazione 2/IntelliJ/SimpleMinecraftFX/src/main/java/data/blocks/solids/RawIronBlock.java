package data.blocks.solids;

import data.blocks.interfaces.IronSwordInterface;
import data.blocks.interfaces.SmeltableBlock;

public class RawIronBlock extends AbstractMineableBlock implements SmeltableBlock {
    public static final int DEFAULT_MINE_VALUE = 8;
    public RawIronBlock() {
        super();
        this.blockname = "Raw Iron";
        this.content = 'I';
        this.mineValue = DEFAULT_MINE_VALUE;
    }

    public IronSwordInterface smelt() {

        return new IronSwordBlock();
    }
}
