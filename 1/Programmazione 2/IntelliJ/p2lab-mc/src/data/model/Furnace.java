package data.model;

import data.BlockFactory;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;

public class Furnace {
    private SmeltableBlock furnaceInput;
    private Block furnaceOutput;
    private BlockFactory bf;

    public Furnace(BlockFactory bf){
        this.bf = bf;
        this.reset_furnace();
    }
    private void reset_furnace(){
        this.furnaceInput = bf.nullBlock();
        this.furnaceOutput = bf.nullBlock();
    }

    public void setInput(SmeltableBlock sb){
        if (this.furnaceInput.isNull()) {
            this.furnaceInput = sb;
            this.furnaceOutput = sb.smelt();
        }
    }
    public SmeltableBlock get_furnaceInput(){
        return this.furnaceInput;
    }
    public Block get_furnaceOutput(){
        return this.furnaceOutput;
    }
    public SmeltableBlock removeInput(){
        SmeltableBlock s = this.furnaceInput;
        this.reset_furnace();
        return s;
    }
    public Block smelt() {
        if (!furnaceInput.isNull()) {
            Block r = this.furnaceOutput;
            this.reset_furnace();
            return r;
        }
        return furnaceInput;
    }
}
