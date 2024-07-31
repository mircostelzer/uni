package controllers.fine_grained;

import Utils.Coordinates;
import controllers.MainControllerInterface;
import visual.GUI.MainGui;
import visual.textual.MainView;

public class FGMainController extends AbstractFGController implements MainControllerInterface {
    private MainView mainView;
    private MainGui mainGui;
    private FGMapController fgMapController;
    private FGFurnaceController fgFurnaceController;
    private FGInventoryController fgInventoryController;

    public FGMainController(MainView mainView) {
        super();
        this.mainView = mainView;
        this.mainGui = new MainGui(this);
        fgFurnaceController = new FGFurnaceController(mainGui.getFurnacePane(), mainView.getFurnace(), this);
        fgInventoryController = new FGInventoryController(mainView.getInventory(), mainGui.getInventoryPane(), this);
        fgMapController = new FGMapController(mainView.getMap(), mainGui.getMapPane());
    }

    @Override
    public void smelt() {

    }

    @Override
    public void move_into_inventory_from_furnace() {

    }

    @Override
    public void move_into_furnace_from_inventory(int i) {

    }

    @Override
    public void pick_up_block(Coordinates coordinates) {

    }

    @Override
    public void toggle_inventory_comparator() {

    }

    @Override
    public void efficient_redraw() {

    }

    @Override
    public void not_efficient_redraw() {

    }
}
