package view.GUI.handlers;

import controller.simple.MainSimpleController;
import utils.MapCoordinates;

public class BlockPaneClickHandlerFactory {

    private MainSimpleController mc;

    public BlockPaneClickHandlerFactory(MainSimpleController mc){
        this.mc = mc;
    }

    public BlockPanePickUpClickHandler createNewPickUpHandler(MapCoordinates c){
        return new BlockPanePickUpClickHandler(mc,c);
    }
}
