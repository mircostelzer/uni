package controllers.fine_grained;

import Utils.BlockErrorException;
import Utils.Coordinates;
import Utils.WrongCoordinatesException;
import controllers.AbstractMainController;
import controllers.MainVisualInterface;
import controllers.SimpleController;
import javafx.scene.control.Alert;
import visual.GUI.MainGui;
import visual.textual.MainView;

import java.util.Collection;
import java.util.Iterator;

public class FGMainController extends AbstractMainController implements FGController, MainVisualInterface {
    private MainGui mainGui;
    private AbstractFGController afgHelper;


    public FGMainController(MainView mainView) {
        super(mainView);
        this.mainGui = new MainGui(this);
        this.setFurnaceController(new FGFurnaceController(mainGui.getFurnacePane(), mainView.getFurnace(), this));
        this.setMapController(new FGMapController(mainView.getMap(), mainGui.getMapPane()));
        this.setInventoryController(new FGInventoryController(mainView.getInventory(), mainGui.getInventoryPane(), this));
        afgHelper = new FGMainControllerHelper();
    }

    @Override
    public void smelt() {
        this.mainView.smelt();
        this.add_efficiency_enabler(furnaceController);
        this.add_efficiency_enabler(inventoryController);
        this.redraw();
    }

    @Override
    public void move_into_inventory_from_furnace() {
        this.mainView.move_into_inventory_from_furnace();
        this.add_efficiency_enabler(furnaceController);
        this.add_efficiency_enabler(inventoryController);
        this.redraw();
    }

    @Override
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
        this.add_efficiency_enabler(furnaceController);
        this.add_efficiency_enabler(inventoryController);
        this.redraw();
    }

    @Override
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
        this.add_efficiency_enabler(mapController);
        this.add_efficiency_enabler(inventoryController);
        this.redraw();
    }

    @Override
    public void add_random_blocks(int n) {
        this.mainView.add_random_blocks(n);
        this.add_efficiency_enabler(mapController);
        this.redraw();
    }

    @Override
    public void toggle_inventory_comparator() {
        this.mainView.toggle_inventory_comparator();
        this.add_efficiency_enabler(inventoryController);
        this.redraw();
    }

    @Override
    public void efficient_redraw() {
        for (Iterator<Object> it = this.get_efficiency_enabler().iterator(); it.hasNext(); ) {
            AbstractFGController controller = (AbstractFGController) it.next();
            controller.redraw();
        }
    }

    @Override
    public void not_efficient_redraw() {
        for (SimpleController simpleController : this.controllerList) {
            simpleController.redraw();
        }
    }

    @Override
    public void add_efficiency_enabler(Object o) {
        this.afgHelper.add_efficiency_enabler(o);
    }

    @Override
    public Collection<Object> get_efficiency_enabler() {
        return this.afgHelper.get_efficiency_enabler();
    }

    public MainGui getMainGui() {
        return this.mainGui;
    }

    @Override
    public void redraw() {
        if (this.get_efficiency_enabler().isEmpty()) {
            this.not_efficient_redraw();
        }
        else {
            this.efficient_redraw();
        }
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
}
