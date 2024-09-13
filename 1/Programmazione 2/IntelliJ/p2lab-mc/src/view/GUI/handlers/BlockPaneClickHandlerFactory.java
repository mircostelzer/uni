package view.GUI.handlers;

import controller.main.MainControllerInterface;
import utils.MapCoordinates;

public class BlockPaneClickHandlerFactory {

    private MainControllerInterface mc;

    public BlockPaneClickHandlerFactory(MainControllerInterface mc){
        this.mc = mc;
    }

    public BlockPanePickUpClickHandler createNewPickUpHandler(MapCoordinates c){
        return new BlockPanePickUpClickHandler(mc,c);
    }
}
