package data.blocks.solids;

import data.blocks.interfaces.IronSwordInterfaceBlock;

class IronSwordBlock extends AbstractSolidBlock implements IronSwordInterfaceBlock {
    IronSwordBlock(){
        super();
        this.content = '/';
        this.blockname = "Iron Sword";
    }
}
