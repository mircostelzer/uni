package data.blocks.solids;

import data.blocks.AbstractBlock;

public abstract class AbstractSolidBlock extends AbstractBlock {
    protected AbstractSolidBlock(){
        super();
        this.fall_through = false;
        this.falls_with_gravity = false;
        this.pickable = true;
    }
}
