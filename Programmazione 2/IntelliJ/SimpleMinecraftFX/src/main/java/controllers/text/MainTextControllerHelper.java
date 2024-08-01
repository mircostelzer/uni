package controllers.text;

import visual.printer.FurnacePrinter;
import visual.printer.InventoryPrinter;
import visual.printer.MainPrinter;
import visual.printer.MapPrinter;

public class MainTextControllerHelper extends AbstractTextController {
    MapPrinter mapPrinter;
    FurnacePrinter furnacePrinter;
    InventoryPrinter inventoryPrinter;

    MainTextControllerHelper() {
        super();
        this.tp = new MainPrinter();
    }

    public void update(MapPrinter mapPrinter, FurnacePrinter furnacePrinter, InventoryPrinter inventoryPrinter) {
        this.mapPrinter = mapPrinter;
        this.furnacePrinter = furnacePrinter;
        this.inventoryPrinter = inventoryPrinter;
    }
    @Override
    public void updatePrinter() {
        ((MainPrinter)tp).update(mapPrinter, furnacePrinter, inventoryPrinter);
    }
}
