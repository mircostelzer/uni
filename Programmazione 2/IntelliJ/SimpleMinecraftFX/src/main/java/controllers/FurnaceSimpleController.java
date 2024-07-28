package controllers;

import javafx.geometry.Pos;
import visual.GUI.BlockPane;
import visual.GUI.FurnacePane;
import visual.textual.Furnace;

public class FurnaceSimpleController implements SimpleController {
    private Furnace furnace;
    private FurnacePane furnacePane;

    public FurnaceSimpleController(Furnace furnace, FurnacePane furnacePane) {
        this.furnace = furnace;
        this.furnacePane = furnacePane;
        this.redraw();
    }



    public void redraw() {
        this.furnacePane.getChildren().clear();
        this.furnacePane.addText();
        this.furnacePane.setInput(new BlockPane(this.furnace.getInput()));
        this.furnacePane.addArrow();
        this.furnacePane.setOutput(new BlockPane(this.furnace.getOutput()));
        this.furnacePane.setAlignment(Pos.TOP_CENTER);
        this.furnacePane.setSpacing(10);
    }
}
