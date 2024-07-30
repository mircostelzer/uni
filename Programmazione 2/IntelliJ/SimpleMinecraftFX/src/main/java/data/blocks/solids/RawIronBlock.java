package data.blocks.solids;

import data.blocks.interfaces.IronSwordInterface;
import data.blocks.interfaces.SmeltableBlock;

public class RawIronBlock extends AbstractMineableBlock implements SmeltableBlock {
    public RawIronBlock() {
        super();
        this.blockname = "Raw Iron";
        this.content = 'I';
        this.mineValue = 8;
    }

    public IronSwordInterface smelt() {

        return new IronSwordBlock();
    }
}
