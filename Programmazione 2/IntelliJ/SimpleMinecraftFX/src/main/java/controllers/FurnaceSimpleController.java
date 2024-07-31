package controllers;

import javafx.geometry.Pos;
import visual.GUI.BlockPane;
import visual.GUI.FurnaceBlockPane;
import visual.GUI.FurnacePane;
import visual.textual.Furnace;

public class FurnaceSimpleController implements SimpleController {
    private Furnace furnace;
    private FurnacePane furnacePane;
    private MainControllerInterface mainController;

    public FurnaceSimpleController(Furnace furnace, FurnacePane furnacePane, MainControllerInterface mainController) {
        this.furnace = furnace;
        this.furnacePane = furnacePane;
        this.mainController = mainController;
        this.redraw();
    }



    public void redraw() {
        this.furnacePane.getChildren().clear();
        this.furnacePane.addText();
        this.furnacePane.setInput(new FurnaceBlockPane(this.furnace.getInput(), mainController));
        this.furnacePane.addArrow();
        this.furnacePane.setOutput(new FurnaceBlockPane(this.furnace.getOutput(), mainController));
        this.furnacePane.setAlignment(Pos.TOP_CENTER);
        this.furnacePane.setSpacing(10);
    }
}
