package controller.textual;

import data.model.Map;
import utils.BlockErrorException;
import utils.MapCoordinates;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import view.textual.MapPrinter;

public class TextMapController extends AbstractTextController{
    Map m;

    TextMapController(Map m){
        this.m = m;
        this.tp = new MapPrinter();
    }

    void updatePrinter() {
        ((MapPrinter) tp).update(this.m.getContent());
    }

}