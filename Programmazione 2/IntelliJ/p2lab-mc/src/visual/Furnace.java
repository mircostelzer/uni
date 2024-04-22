package visual;

import Utils.MapCoordinates;
import data.BlockFactory;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import data.blocks.NullBlock;

class Furnace {
    private SmeltableBlock furnaceInput;
    private Block furnaceOutput;
    private BlockFactory bf;

    public Furnace(BlockFactory bf){
        this.bf = bf;
        furnaceInput = this.bf.nullBlock();
        furnaceOutput = furnaceInput.smelt();
    }

    public void display_on_out(){
        System.out.println("|| "+this.furnaceInput.display()+" --> "+this.furnaceOutput.display()+" ||");
    }

    public void move_into_furnace(MapCoordinates c, Map m) {
        if (!c.is_inbound()){
            return;
        }
        if (m.is_smeltable(c)){
            SmeltableBlock sb = m.gimme_smeltable(c);
            this.furnaceInput = sb;
            this.furnaceOutput = sb.smelt();
        }else{
            System.out.println("Selection is not smeltable");
        }
    }
    public void smelt() {
        if (!(furnaceInput instanceof NullBlock)) {
            System.out.println("Smelting "+furnaceInput.toString()+" into "+furnaceOutput.toString());
            this.furnaceInput = bf.nullBlock();
            System.out.println("No inventory where to store the smelted "+furnaceOutput.toString());
            this.furnaceOutput = bf.nullBlock();
        }
    }
}
