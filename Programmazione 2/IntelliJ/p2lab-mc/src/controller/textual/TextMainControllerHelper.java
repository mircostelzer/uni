package controller.textual;

import view.textual.FurnacePrinter;
import view.textual.InventoryPrinter;
import view.textual.MainPrinter;
import view.textual.MapPrinter;

public class TextMainControllerHelper extends AbstractTextController {
    MapPrinter m;
    FurnacePrinter f;
    InventoryPrinter i;

    TextMainControllerHelper(){
        super();
        tp = new MainPrinter();
    }
    public void update(MapPrinter m, FurnacePrinter f, InventoryPrinter i){
        this.m = m;
        this.f = f;
        this.i = i;
    }

    public void updatePrinter() {
        ((MainPrinter)tp).update(m, f, i);
    }
}
