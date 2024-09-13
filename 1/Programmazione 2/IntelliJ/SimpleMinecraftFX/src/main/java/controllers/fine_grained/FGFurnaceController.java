package controllers.fine_grained;

import controllers.MainControllerInterface;
import javafx.geometry.Pos;
import visual.GUI.FurnaceBlockPane;
import visual.GUI.FurnacePane;
import visual.textual.Furnace;

import java.util.Collection;

public class FGFurnaceController extends AbstractFGController {
    private Furnace furnace;
    private FurnacePane furnacePane;
    MainControllerInterface mainController;

    public FGFurnaceController(FurnacePane furnacePane, Furnace furnace, MainControllerInterface mainController) {
        super();
        this.furnacePane = furnacePane;
        this.furnace = furnace;
        this.mainController = mainController;
        this.redraw();
    }

    @Override
    public void efficient_redraw() {
        this.furnacePane.getChildren().clear();
        this.furnacePane.addText();
        this.furnacePane.setInput(new FurnaceBlockPane(this.furnace.getInput(), mainController));
        this.furnacePane.addArrow();
        this.furnacePane.setOutput(new FurnaceBlockPane(this.furnace.getOutput(), mainController));
        this.furnacePane.setAlignment(Pos.TOP_CENTER);
        this.furnacePane.setSpacing(10);
    }

    @Override
    public void not_efficient_redraw() {
        this.efficient_redraw();
    }

    public void add_efficiency_enabler(Object o) {
        return;
    }
}
