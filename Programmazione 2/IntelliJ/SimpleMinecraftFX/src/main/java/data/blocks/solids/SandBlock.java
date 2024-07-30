package data.blocks.solids;

import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;

public class SandBlock extends AbstractMineableBlock implements SmeltableBlock {

    public SandBlock() {
        super();
        this.falls_with_gravity = true;
        this.fall_through = false;
        this.blockname = "Sand";
        this.content = 'S';
        this.pickable = true;
        this.mineValue = 3;
    }

    public Block smelt() {
        return new GlassBlock();
    }
}
