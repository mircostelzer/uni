package controllers.text;

import Utils.BlockErrorException;
import Utils.Coordinates;
import Utils.WrongCoordinatesException;
import controllers.MainControllerInterface;
import controllers.AbstractMainController;
import controllers.SimpleController;
import visual.printer.*;
import visual.textual.MainView;

import java.util.ArrayList;

public class MainTextController extends AbstractMainController implements TextControllerInterface { ;
    private MainTextControllerHelper tmcHelper;

    public MainTextController(MainView mainView) {
        super(mainView);
        this.setMapController(new MapTextController(mainView.getMap()));
        this.setFurnaceController(new FurnaceTextController(mainView.getFurnace()));
        this.setInventoryController(new InventoryTextController(mainView.getInventory()));
        this.tmcHelper = new MainTextControllerHelper();
    }


    public void updatePrinter() {
        for (SimpleController simpleController : this.controllerList) {
            ((TextControllerInterface)simpleController).updatePrinter();
        }
        this.tmcHelper.update(
                (MapPrinter) ((MapTextController) ((ArrayList<?>)this.controllerList).get(0)).getTextPrinter(),
                (FurnacePrinter) ((FurnaceTextController) ((ArrayList<?>)this.controllerList).get(1)).getTextPrinter(),
                (InventoryPrinter) ((InventoryTextController) ((ArrayList<?>)this.controllerList).get(2)).getTextPrinter()
        );
        this.tmcHelper.updatePrinter();
    }

    @Override
    public TextPrinter getTextPrinter() {
        return this.tmcHelper.getTextPrinter();
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

    public void add_random_blocks(int n) {
        this.mainView.add_random_blocks(n);
    }

    @Override
    public void redraw() {
        this.updatePrinter();
        this.tmcHelper.redraw();
    }
}
