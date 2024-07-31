package view.GUI.handlers;

import controller.main.MainControllerInterface;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import utils.MapCoordinates;

class BlockPanePickUpClickHandler implements EventHandler<MouseEvent> {

    private MainControllerInterface mc;
    private MapCoordinates c;

    BlockPanePickUpClickHandler(MainControllerInterface mc, MapCoordinates c){
        this.mc = mc;
        this.c = c;
    }

    public void handle(MouseEvent mouseEvent) {
        // usare questi solo per i blocchi dentro alla Map
        mc.pick_block(c);
        if (mouseEvent.isShiftDown()){
//            System.err.println("shi");
        }
    }
}
