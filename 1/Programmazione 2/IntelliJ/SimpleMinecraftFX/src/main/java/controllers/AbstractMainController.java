package controllers;

import Utils.Coordinates;
import visual.GUI.MainGui;
import visual.textual.MainView;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractMainController implements MainControllerInterface {
    protected SimpleController mapController;
    protected SimpleController inventoryController;
    protected SimpleController furnaceController;
    protected Collection<SimpleController> controllerList;
    protected MainView mainView;
    MainGui mainGui;

    protected AbstractMainController(MainView mainView) {
        this.mainView = mainView;
        this.controllerList = new ArrayList<>();
    }

    public void setMapController(SimpleController mapController) {
        this.mapController = mapController;
        controllerList.add(mapController);
    }

    public void setInventoryController(SimpleController inventoryController) {
        this.inventoryController = inventoryController;
        controllerList.add(inventoryController);
    }

    public void setFurnaceController(SimpleController furnaceController) {
        this.furnaceController = furnaceController;
        controllerList.add(furnaceController);
    }

    public abstract void smelt();
    public abstract void move_into_furnace_from_inventory(int i);
    public abstract void move_into_inventory_from_furnace();
    public abstract void pick_up_block(Coordinates coordinates);
    public abstract void add_random_blocks(int n);
}
