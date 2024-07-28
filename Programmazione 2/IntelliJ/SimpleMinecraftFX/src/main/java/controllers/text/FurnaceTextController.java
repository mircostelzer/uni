package controllers.text;

import visual.printer.FurnacePrinter;
import visual.textual.Furnace;

public class FurnaceTextController extends AbstractTextController  {
    private Furnace furnace;

    public FurnaceTextController(Furnace furnace) {
        this.furnace = furnace;
        this.tp = new FurnacePrinter();
    }

    @Override
    void updatePrinter() {
        ((FurnacePrinter)this.tp).update(this.furnace.getInput(), this.furnace.getOutput());
    }
}
