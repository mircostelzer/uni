package data.blocks;

import data.blocks.interfaces.Block;

public abstract class AbstractBlock implements Block {
    protected char content;
    protected boolean falls_with_gravity;
    protected boolean fall_through;
    protected boolean pickable;
    protected String blockname;

    protected AbstractBlock(){
        this.pickable = false;
    }

    public char display(){
        return this.content;
    }
    public boolean isFalls_with_gravity(){
        return this.falls_with_gravity;
    }
    public boolean isFall_through(){
        return this.fall_through;
    }
    public boolean isPickable(){
        return this.pickable;
    }
    public boolean isNull(){
        return (this instanceof NullBlock) ;
    }

    public String toString(){
        return this.blockname+" ["+this.content+"]";
    }

    public String display_in_inventory(){
        return "["+this.content+"]";
    }
}
