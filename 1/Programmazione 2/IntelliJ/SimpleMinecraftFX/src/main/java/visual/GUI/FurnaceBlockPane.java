package visual.GUI;

import controllers.MainControllerInterface;
import controllers.MainSimpleController;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class FurnaceBlockPane extends BlockPane {

    public FurnaceBlockPane(Block b, MainControllerInterface mainController) {
        super(b);
        if (b instanceof SmeltableBlock) {
            this.setOnMouseClicked(new InputListener(mainController));
        }
        else {
            this.setOnMouseClicked(new OutputListener(mainController));
        }
    }

    class InputListener implements EventHandler<MouseEvent> {
        MainControllerInterface mainController;

        public InputListener(MainControllerInterface mainController) {
            this.mainController = mainController;
        }

        @Override
        public void handle(MouseEvent event) {
            this.mainController.move_into_inventory_from_furnace();
        }
    }

    class OutputListener implements EventHandler<MouseEvent> {
        MainControllerInterface mainController;

        public OutputListener(MainControllerInterface mainController) {
            this.mainController = mainController;
        }

        @Override
        public void handle(MouseEvent mouseEvent) {
            this.mainController.smelt();
        }
    }
}
