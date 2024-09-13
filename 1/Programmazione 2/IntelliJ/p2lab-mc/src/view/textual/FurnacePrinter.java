package view.textual;

import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;

public class FurnacePrinter implements TextPrinter{
    private SmeltableBlock in;
    private Block out;

    public FurnacePrinter(){}

    public void update(SmeltableBlock in, Block out){
        this.in = in;
        this.out = out;
    }

    public void display_on_out(){
        System.out.println("|| "+in.display()+" --> "+out.display()+" ||");
    }
}
