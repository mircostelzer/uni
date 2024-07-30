package view.GUI.handlers;

import controller.simple.MainSimpleController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import utils.MapCoordinates;

class BlockPanePickUpClickHandler implements EventHandler<MouseEvent> {

    private MainSimpleController mc;
    private MapCoordinates c;

    BlockPanePickUpClickHandler(MainSimpleController mc, MapCoordinates c){
        this.mc = mc;
        this.c = c;
    }

    public void handle(MouseEvent mouseEvent) {
        // usare questi solo per i blocchi dentro alla Map
        mc.pick_block(c);
    }
}
