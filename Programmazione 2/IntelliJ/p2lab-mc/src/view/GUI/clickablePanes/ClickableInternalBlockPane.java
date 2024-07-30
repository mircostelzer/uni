package view.GUI.clickablePanes;

import controller.simple.MainSimpleController;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import utils.MapCoordinates;
import view.GUI.BlockPane;

public class ClickableInternalBlockPane extends BlockPane {

    public ClickableInternalBlockPane(Block bb, MainSimpleController mc) {
        super(bb);
        EventHandler<MouseEvent> bpch;
        if ( bb instanceof SmeltableBlock) {
            // se e` smeltable, e` l'input
            bpch = new BlockPaneMoveBackClickHandler(mc);
        } else {
            // altrimenti e` l'output
            bpch = new BlockPaneSmeltClickHandler(mc);
        }
        this.setOnMouseClicked(bpch);
    }

    class BlockPaneSmeltClickHandler implements EventHandler<MouseEvent> {
        private MainSimpleController mc;

        BlockPaneSmeltClickHandler(MainSimpleController mc) {
            this.mc = mc;
        }
        public void handle(MouseEvent mouseEvent) {
            // usare questi solo per i blocchi come output della Fornace
            mc.smelt();
        }
    }

    class BlockPaneMoveBackClickHandler implements EventHandler<MouseEvent> {
        private MainSimpleController mc;

        BlockPaneMoveBackClickHandler(MainSimpleController mc) {
            this.mc = mc;
        }
        public void handle(MouseEvent mouseEvent) {
            // usare questi solo per i blocchi come input della Fornace
            mc.move_from_furnace_to_inventory();
        }
    }
}
