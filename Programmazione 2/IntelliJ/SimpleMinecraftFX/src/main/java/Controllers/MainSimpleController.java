package Controllers;

import Utils.Coordinates;
import visual.GUI.MainGui;
import visual.textual.MainView;

import java.util.ArrayList;
import java.util.Collection;

public class MainSimpleController implements SimpleController {
    private MainView mainView;
    private MainGui mainGui;
    private Collection<SimpleController> controllersList;
    private FurnaceSimpleController furnaceController;
    private InventorySimpleController inventoryController;
    private MapSimpleController mapController;

    public MainSimpleController (MainView mainView) {
        this.mainView = mainView;
        this.mainGui = new MainGui(this);
        this.controllersList = new ArrayList<>();
        this.furnaceController = new FurnaceSimpleController(mainView.getFurnace(), mainGui.getFurnacePane());
        this.inventoryController = new InventorySimpleController(mainView.getInventory(), mainGui.getInventoryPane());
        this.mapController = new MapSimpleController(mainView.getMap(), mainGui.getMapPane());
        this.controllersList.add(furnaceController);
        this.controllersList.add(inventoryController);
        this.controllersList.add(mapController);
    }

    public void redraw() {
        for (SimpleController controller : controllersList) {
            controller.redraw();
        }
    }

    public void smelt() {
        this.mainView.smelt();
        this.furnaceController.redraw();
        this.inventoryController.redraw();
    }

    public void move_into_inventory_from_furnace() {
        this.mainView.move_into_inventory_from_furnace();
        this.inventoryController.redraw();
        this.furnaceController.redraw();
    }

    public void move_into_furnace_from_inventory(int i) {
        this.mainView.move_into_furnace_from_inventory(i);
        this.inventoryController.redraw();
        this.furnaceController.redraw();
    }

    public void pick_up_block(Coordinates coords) {
        this.mainView.pick_up_block(coords);
        this.mapController.redraw();
        this.inventoryController.redraw();
    }

    public void toggle_inventory_comparator() {
        this.mainView.toggle_inventory_comparator();
        this.inventoryController.redraw();
    }

    public MainGui getMainGui() {
        return this.mainGui;
    }
}
