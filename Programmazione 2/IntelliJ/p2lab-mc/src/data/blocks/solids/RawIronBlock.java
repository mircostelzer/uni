package data.blocks.solids;

import data.blocks.interfaces.IronSwordInterfaceBlock;
import data.blocks.interfaces.SmeltableBlock;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock {

    public RawIronBlock(){
        super();
        this.content = 'I';
        this.blockname = "Raw Iron";
    }

    public IronSwordInterfaceBlock smelt() {
        return new IronSwordBlock();
    }
}
