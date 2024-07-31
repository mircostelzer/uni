package controller.textual;

import data.model.Furnace;
import view.textual.FurnacePrinter;

public class TextFurnaceController extends AbstractTextController {
    private Furnace f;

    TextFurnaceController(Furnace f){
        tp = new FurnacePrinter();
        this.f = f;
    }

    public void updatePrinter() {
        ((FurnacePrinter)tp).update(f.get_furnaceInput(),f.get_furnaceOutput());
    }

}