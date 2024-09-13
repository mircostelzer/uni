package view.GUI.clickablePanes;

import controller.main.MainControllerInterface;
import data.blocks.interfaces.Block;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.GUI.BlockPane;

public class ClickableAnonymousBlockPane extends BlockPane {

    public ClickableAnonymousBlockPane(Block bb, MainControllerInterface mc, int index) {
        super(bb);
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
               @Override
               public void handle(MouseEvent mouseEvent) {
                   // usare solo per i blocchi di inventory
                   mc.move_from_inventory_to_furnace(index);
               }
           }
        );
    }
}
