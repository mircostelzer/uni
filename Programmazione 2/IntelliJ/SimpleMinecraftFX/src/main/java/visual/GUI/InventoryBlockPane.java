package visual.GUI;

import controllers.MainSimpleController;
import data.blocks.interfaces.Block;
import javafx.event.EventHandler;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

public class InventoryBlockPane extends BlockPane {

    public InventoryBlockPane(Block b, MainSimpleController mainController, int i) {
        super(b);
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                mainController.move_into_furnace_from_inventory(i);
            }
        });
    }
}
