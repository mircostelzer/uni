package view.GUI.clickablePanes;

import data.blocks.interfaces.Block;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.GUI.BlockPane;

public class ClickableExternalBlockPane extends BlockPane {

    public ClickableExternalBlockPane(Block bb, EventHandler<MouseEvent> bg) {
        super(bb);
        this.setOnMouseClicked(bg);
    }
}
