package controller.finegrained;

import controller.simple.SimpleController;
import data.blocks.interfaces.Block;
import view.GUI.BlockPane;

public class BlockController implements SimpleController {
    private Block b;
    private BlockPane bp;

    BlockController(Block b, BlockPane bp){
        this.b = b;
        this.bp = bp;
    }

    public void redraw() {

    }
}
