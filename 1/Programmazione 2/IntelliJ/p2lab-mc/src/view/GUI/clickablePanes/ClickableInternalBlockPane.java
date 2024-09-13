package view.GUI.clickablePanes;

import controller.main.MainControllerInterface;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.GUI.BlockPane;

public class ClickableInternalBlockPane extends BlockPane {

    public ClickableInternalBlockPane(Block bb, MainControllerInterface mc) {
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
        private MainControllerInterface mc;

        BlockPaneSmeltClickHandler(MainControllerInterface mc) {
            this.mc = mc;
        }
        public void handle(MouseEvent mouseEvent) {
            // usare questi solo per i blocchi come output della Fornace
            mc.smelt();
        }
    }

    class BlockPaneMoveBackClickHandler implements EventHandler<MouseEvent> {
        private MainControllerInterface mc;

        BlockPaneMoveBackClickHandler(MainControllerInterface mc) {
            this.mc = mc;
        }
        public void handle(MouseEvent mouseEvent) {
            // usare questi solo per i blocchi come input della Fornace
            mc.move_from_furnace_to_inventory();
        }
    }
}
