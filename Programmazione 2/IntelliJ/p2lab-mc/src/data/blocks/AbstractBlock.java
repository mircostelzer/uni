package data.blocks;

import data.blocks.interfaces.Block;

public abstract class AbstractBlock implements Block {
    protected char content;
    protected boolean falls_with_gravity;
    protected boolean fall_through;
    protected String blockname;

    public char display(){
        return this.content;
    }
    public boolean isFalls_with_gravity(){
        return this.falls_with_gravity;
    }
    public boolean isFall_through(){
        return this.fall_through;
    }

    public String toString(){
        return this.blockname+" ["+this.content+"]";
    }
}
