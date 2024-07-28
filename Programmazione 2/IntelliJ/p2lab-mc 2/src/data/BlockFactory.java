package data;

import data.blocks.interfaces.Block;
import data.blocks.*;
import data.blocks.interfaces.IronSwordInterfaceBlock;
import data.blocks.solids.EarthBlock;
import data.blocks.solids.GlassBlock;
import data.blocks.solids.RawIronBlock;

import java.util.Random;

public class BlockFactory {
    private static final int RAND_UPPERBOUND = 3;
    public BlockFactory(){}

    public Block random_block(){
        Random rand = new Random();
        int r = rand.nextInt(RAND_UPPERBOUND);
        switch (r){
            case 0:
                return this.rawIronBlock();
            case 1:
                return this.sand_block();
            case 2:
                return this.earth_block();
            default:
                return this.nullBlock();
        }
    }
    public Block truly_random_block() {
        Random rand = new Random();
        int r = rand.nextInt(RAND_UPPERBOUND);
        switch (r){
            case 0:
                return this.rawIronBlock();
            case 1:
                return this.sand_block();
            case 2:
                return this.earth_block();
            case 3:
                return this.waterBlock();
            case 4:
                return this.default_block();
            case 5:
                return new GlassBlock();
            default:
                return this.nullBlock();
        }
    }

    public AirBlock default_block(){
        return new AirBlock();
    }
    public SandBlock sand_block(){
        return new SandBlock();
    }
    public WaterBlock waterBlock(){
        return new WaterBlock();
    }
    public NullBlock nullBlock(){
        return new NullBlock();
    }
    public RawIronBlock rawIronBlock(){
        return new RawIronBlock();
    }
    public EarthBlock earth_block(){
        return new EarthBlock();
    }

}
