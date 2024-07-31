package controller.simple;

import controller.main.MainControllerInterface;
import data.model.MainFunctionalities;
import utils.MapCoordinates;
import utils.NoGuiException;
import view.GUI.MainGUI;

import java.util.ArrayList;
import java.util.Collection;

public class MainSimpleController implements SimpleController, MainControllerInterface {
    private MainFunctionalities mui;
    private MainGUI mgui;
    private Collection<SimpleController> controllerslist;

    MapSimpleController mapc;
    InventorySimpleController invc;
    FurnaceSimpleController furc;

    public MainSimpleController(MainFunctionalities m){
        this.mui = m;
        this.mgui = new MainGUI(this);

        mapc = new MapSimpleController(mui.getMap(),mgui.getMapPane());
        invc = new InventorySimpleController(mui.getInventory(),mgui.getInventoryPane(),this);
        furc = new FurnaceSimpleController(mui.getFurnace(),mgui.getFurnacePane(),this);

        controllerslist = new ArrayList<SimpleController>();
        controllerslist.add(mapc);
        controllerslist.add(invc);
        controllerslist.add(furc);
    }

    public MainGUI getMainGUI(){
        return this.mgui;
    }

    public void redraw() {
        for (SimpleController simpleController : this.controllerslist) {
            simpleController.redraw();
        }
    }

    public void smelt(){
        this.mui.smelt();
        this.furc.redraw();
        this.invc.redraw();
    }
    public void move_from_furnace_to_inventory() {
        this.mui.move_into_inventory_from_furnace();
        this.furc.redraw();
        this.invc.redraw();
    }
    public void move_from_inventory_to_furnace(int index){
        this.mui.move_into_furnace_from_inventory(index);
        this.furc.redraw();
        this.invc.redraw();
    }
    public void pick_block(MapCoordinates c){
        this.mui.pick_up_block(c);
        this.mapc.set_drawme(c);
        this.mapc.redraw();
        this.invc.redraw();
    }
    public void toggle_sort_inventory(){
        this.mui.toggle_inventory_comparator();
        this.invc.redraw();
    }
    public void add_random_block(){
        MapCoordinates c = MapCoordinates.randomCoords();
        this.mui.add_random_block_at_coords(c);
        this.mapc.set_drawme(c);
        this.mapc.redraw();
    }
}
