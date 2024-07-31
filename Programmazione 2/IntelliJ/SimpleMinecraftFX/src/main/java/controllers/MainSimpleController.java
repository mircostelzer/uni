package controllers;

import Utils.BlockErrorException;
import Utils.Coordinates;
import Utils.WrongCoordinatesException;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import visual.GUI.MainGui;
import visual.textual.MainView;

import java.util.ArrayList;
import java.util.Collection;

public class MainSimpleController implements MainControllerInterface, SimpleController {
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
        this.furnaceController = new FurnaceSimpleController(mainView.getFurnace(), mainGui.getFurnacePane(), this);
        this.inventoryController = new InventorySimpleController(mainView.getInventory(), mainGui.getInventoryPane(), this);
        this.mapController = new MapSimpleController(mainView.getMap(), mainGui.getMapPane());
        this.controllersList.add(furnaceController);
        this.controllersList.add(inventoryController);
        this.controllersList.add(mapController);

        this.mainGui.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case S:
                    this.toggle_inventory_comparator();
                    break;
                case N:
                    this.add_random_blocks(1);
                    break;
                case R:
                    this.add_random_blocks(10);
                    break;
                default:
            }
        });
    }

    public void redraw() {
        for (SimpleController controller : this.controllersList) {
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
        try {
            this.mainView.move_into_furnace_from_inventory(i);
        }
        catch (BlockErrorException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("This block doesn't allow this operation");
            alert.setContentText("Not a smeltable block");
            alert.showAndWait();

        }
        this.inventoryController.redraw();
        this.furnaceController.redraw();
    }

    public void pick_up_block(Coordinates coords) {
        try {
            this.mainView.pick_up_block(coords);
        }
        catch (BlockErrorException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("This block doesn't allow this operation");
            alert.setContentText("This block cannot be picked up");
            alert.showAndWait();
        }
        catch (WrongCoordinatesException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Coordinates are not inbound");
            alert.showAndWait();
        }
        this.mapController.redraw();
        this.inventoryController.redraw();
    }

    public void toggle_inventory_comparator() {
        this.mainView.toggle_inventory_comparator();
        this.inventoryController.redraw();
    }

    public void add_random_blocks(int n) {
        this.mainView.add_random_blocks(n);
        this.mapController.redraw();
    }

    public void mine(int n, Coordinates coords) {
        try {
            this.mainView.mine(n, coords);
        }
        catch (BlockErrorException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("This block doesn't allow this operation");
            alert.setContentText("Not a mineable block");
            alert.showAndWait();
        }
        catch (WrongCoordinatesException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Coordinates are not inbound");
            alert.showAndWait();
        }
        this.redraw();
    }

    public MainGui getMainGui() {
        return this.mainGui;
    }
}
