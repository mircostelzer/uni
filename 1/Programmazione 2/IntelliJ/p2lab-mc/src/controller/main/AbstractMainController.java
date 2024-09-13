package controller.main;

import controller.MyController;
import data.model.MainFunctionalities;
import utils.MapCoordinates;
import utils.NoGuiException;
import view.GUI.MainGUI;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractMainController implements MainControllerInterface {

    protected MyController mapcontroller;
    protected MyController inventorycontroller;
    protected MyController furnacecontroller;
    protected Collection<MyController> controllerslist;

    protected MainFunctionalities mainfunc;
    MainGUI maingui;

    protected AbstractMainController(MainFunctionalities mui){
        this.mainfunc = mui;
        controllerslist = new ArrayList<MyController>();
    }

    public void setMapcontroller(MyController mapcontroller) {
        this.mapcontroller = mapcontroller;
        controllerslist.add(mapcontroller);
    }
    public void setInventorycontroller(MyController inventorycontroller) {
        this.inventorycontroller = inventorycontroller;
        controllerslist.add(inventorycontroller);
    }
    public void setFurnacecontroller(MyController furnacecontroller) {
        this.furnacecontroller = furnacecontroller;
        controllerslist.add(furnacecontroller);
    }
    public void setMaingui(MainGUI maingui) {
        this.maingui = maingui;
    }

    // si puo` applicare il template method per far si che questi metodi contengano la chiamata a un abstract method che sono gli implementers a finalizzare
    // per riutilizzare codice: tipo ogni smelt nelle classi che estendono questa fa la chiamata a mainfunc.smelt();
    // ogni add_random_block genera delle coordinate casuali e le passa a mainfunc. ...  etc
    public abstract void smelt();
    public abstract void move_from_furnace_to_inventory();
    public abstract void move_from_inventory_to_furnace(int index);
    public abstract void pick_block(MapCoordinates c);
    public abstract void toggle_sort_inventory();
    public abstract void add_random_block();
    public MainGUI getMainGUI() throws NoGuiException {
        if (this.maingui == null){
            throw new NoGuiException();
        }
        return this.maingui;
    }
}
