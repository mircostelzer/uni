package visual.textual;

import data.BlockFactory;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import data.blocks.NullBlock;

public class Furnace {
    private SmeltableBlock furnaceInput;
    private Block furnaceOutput;
    private BlockFactory bf;

    Furnace(BlockFactory bf){
        this.bf = bf;
        this.reset_furnace();
    }

    public void display_on_out(){
        System.out.println("|| "+this.furnaceInput.display()+" --> "+this.furnaceOutput.display()+" ||");
    }

    private void reset_furnace(){
        this.furnaceInput = bf.nullBlock();
        this.furnaceOutput = bf.nullBlock();
    }

    public void setInput(SmeltableBlock sb){
        this.furnaceInput = sb;
        this.furnaceOutput = sb.smelt();
    }
    public SmeltableBlock getInput(){
        SmeltableBlock s = this.furnaceInput;
        this.reset_furnace();
        return s;
    }

    public SmeltableBlock get_furnaceInput(){
        return this.furnaceInput;
    }
    public Block get_furnaceOutput(){
        return this.furnaceOutput;
    }

    public Block smelt() {
        if (!(furnaceInput instanceof NullBlock)) {
            System.out.println("Smelting "+furnaceInput.toString()+" into "+furnaceOutput.toString());
            Block r = this.furnaceOutput;
            this.reset_furnace();
            return r;
        }
        return furnaceInput;
    }
}