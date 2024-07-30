package visual.GUI;

import controllers.MainSimpleController;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class FurnaceBlockPane extends BlockPane {
    private MainSimpleController mainController;

    public FurnaceBlockPane(Block b, MainSimpleController mainController) {
        super(b);
        this.mainController = mainController;
        if (b instanceof SmeltableBlock) {
            this.setOnMouseClicked(new InputListener(mainController));
        }
        else {
            this.setOnMouseClicked(new OutputListener(mainController));
        }
    }

    class InputListener implements EventHandler<MouseEvent> {
        MainSimpleController mainController;

        public InputListener(MainSimpleController mainController) {
            this.mainController = mainController;
        }

        @Override
        public void handle(MouseEvent event) {
            this.mainController.move_into_inventory_from_furnace();
        }
    }

    class OutputListener implements EventHandler<MouseEvent> {
        MainSimpleController mainController;

        public OutputListener(MainSimpleController mainController) {
            this.mainController = mainController;
        }

        @Override
        public void handle(MouseEvent mouseEvent) {
            this.mainController.smelt();
        }
    }
}
