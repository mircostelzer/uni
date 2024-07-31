package controller.finegrained;

import controller.MyController;
import controller.main.AbstractMainController;
import data.model.MainFunctionalities;
import utils.MapCoordinates;
import view.GUI.MainGUI;

import java.util.Collection;
import java.util.Iterator;

public class FGMainController extends AbstractMainController implements FGControllerInterface {
    private MainGUI mgui;
    private AbstractFGController afg_helper;

    public FGMainController(MainFunctionalities m){
        super(m);
        this.mgui = new MainGUI(this);

        this.setMapcontroller( new FGMapController(mainfunc.getMap(),mgui.getMapPane()) );
        this.setInventorycontroller( new FGInventoryController(mainfunc.getInventory(),mgui.getInventoryPane(),this) );
        this.setFurnacecontroller( new FGFurnaceController(mainfunc.getFurnace(),mgui.getFurnacePane(),this) );

        afg_helper = new FGMainControllerHelper();
    }

    public MainGUI getMainGUI(){
        return this.mgui;
    }
    public void not_efficient_redraw() {
        for (MyController simpleController : this.controllerslist) {
            simpleController.redraw();
        }
    }
    public void efficient_redraw(){
        Iterator<Object> i = this.get_efficiency_enabler().iterator();
        while (i.hasNext()){
            AbstractFGController c = (AbstractFGController) i.next();
            c.redraw();
        }
    }
    public final void redraw() {
        if (this.get_efficiency_enabler().size() > 0){
            this.efficient_redraw();
            this.get_efficiency_enabler().clear();
        }else{
            this.not_efficient_redraw();
        }
    }
    public Collection<Object> get_efficiency_enabler(){
        return this.afg_helper.get_efficiency_enabler();
    }
    public void add_efficiency_enabler(Object o){
        this.afg_helper.add_efficiency_enabler(o);
    }

    public void smelt(){
        this.mainfunc.smelt();
        this.add_efficiency_enabler(furnacecontroller);
        this.add_efficiency_enabler(inventorycontroller);
        this.redraw();
    }
    public void move_from_furnace_to_inventory() {
        this.mainfunc.move_into_inventory_from_furnace();
        this.add_efficiency_enabler(furnacecontroller);
        this.add_efficiency_enabler(inventorycontroller);
        this.redraw();
    }
    public void move_from_inventory_to_furnace(int index){
        this.mainfunc.move_into_furnace_from_inventory(index);
        this.add_efficiency_enabler(furnacecontroller);
        this.add_efficiency_enabler(inventorycontroller);
        this.redraw();
    }
    public void pick_block(MapCoordinates c){
        this.mainfunc.pick_up_block(c);
        this.add_efficiency_enabler(mapcontroller);
        this.add_efficiency_enabler(inventorycontroller);
        this.redraw();
    }
    public void toggle_sort_inventory(){
        this.mainfunc.toggle_inventory_comparator();
        this.add_efficiency_enabler(inventorycontroller);
        this.redraw();
    }
    public void add_random_block(){
        MapCoordinates c = MapCoordinates.randomCoords();
        this.mainfunc.add_random_block_at_coords(c);
        this.add_efficiency_enabler(mapcontroller);
        this.redraw();
    }
}
