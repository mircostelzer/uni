package controllers.text;

import Utils.BlockErrorException;
import Utils.Coordinates;
import Utils.WrongCoordinatesException;
import visual.printer.FurnacePrinter;
import visual.printer.InventoryPrinter;
import visual.printer.MainPrinter;
import visual.printer.MapPrinter;
import visual.textual.MainView;

public class MainTextController extends AbstractTextController {
    private MainView mainView;
    private MapTextController mtc;
    private FurnaceTextController ftc;
    private InventoryTextController itc;

    public MainTextController(MainView mainView) {
        this.mainView = mainView;
        this.mtc = new MapTextController(this.mainView.getMap());
        this.ftc = new FurnaceTextController(this.mainView.getFurnace());
        this.itc = new InventoryTextController(this.mainView.getInventory());
        this.tp = new MainPrinter();
    }

    @Override
    void updatePrinter() {
        this.mtc.updatePrinter();
        this.ftc.updatePrinter();
        this.itc.updatePrinter();
        ((MainPrinter)this.tp).update((MapPrinter)this.mtc.getTextPrinter(), (FurnacePrinter)this.ftc.getTextPrinter(), (InventoryPrinter)this.itc.getTextPrinter());
    }

    public void smelt() {
        this.mainView.smelt();
    }
    public void move_into_inventory_from_furnace() {
        this.mainView.move_into_inventory_from_furnace();
    }
    public void move_into_furnace_from_inventory(int index) {
        try {
            this.mainView.move_into_furnace_from_inventory(index);
        }
        catch (BlockErrorException e) {
            System.out.println("Not a smeltable block");
        }
    }
    public void pick_up_block(Coordinates c) {
        try {
            this.mainView.pick_up_block(c);
        }
        catch (BlockErrorException e) {
            System.out.println("Block cannot be picked up") ;
        }
        catch (WrongCoordinatesException e) {
            System.out.println("Coordinates are not inbound") ;
        }
    }
    public void toggle_inventory_comparator() {
        this.mainView.toggle_inventory_comparator();
    }
}
