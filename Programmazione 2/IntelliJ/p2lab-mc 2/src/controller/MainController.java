package controller;

import utils.MapCoordinates;
import visual.GUI.MainGUI;
import visual.textual.MainUI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MainController implements Controller{
    private MainUI mui;
    private MainGUI mgui;

    private Collection<Controller> controllerslist;

    public MainController(){
        this.mui = new MainUI();
//        this.mgui = new MainGUI(this);

        Controller mapc = new MapController(mui.getMap(),mgui.getMapPane());
        Controller invc = new InventoryController(mui.getInventory(),mgui.getInventoryPane());
        Controller furc = new FurnaceController(mui.getFurnace(),mgui.getFurnacePane());

        controllerslist = new ArrayList<Controller>();
        controllerslist.add(mapc);
        controllerslist.add(invc);
        controllerslist.add(furc);
    }

    public MainGUI getMainGUI(){
        return this.mgui;
    }

    public void redraw() {
        mui.display_on_out();
        Iterator<Controller> i = this.controllerslist.iterator();
        while (i.hasNext()){
            i.next().redraw();
        }
    }

    public void smelt(){
        this.mui.smelt();
    }
    public void move_from_furnace_to_inventory() {
        this.mui.move_into_inventory_from_furnace();
    }
    public void move_from_inventory_to_furnace(int index){
        this.mui.move_into_furnace_from_inventory(index);
    }
    public void pick_block(MapCoordinates c){
        this.mui.pick_up_block(c);
    }
}
