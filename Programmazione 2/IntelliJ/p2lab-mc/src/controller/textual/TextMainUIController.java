package controller.textual;

import controller.MyController;
import controller.main.AbstractMainController;
import data.model.MainFunctionalities;
import utils.MapCoordinates;
import view.GUI.MainGUI;
import view.textual.*;

import java.util.ArrayList;

public class TextMainUIController extends AbstractMainController implements TextControllerInterface {
    private TextMainControllerHelper tmc_helper;

    public TextMainUIController(){
        this(true);
    }
    public TextMainUIController(boolean random){
        super(new MainFunctionalities(random));

        tmc_helper = new TextMainControllerHelper();

        this.setMapcontroller( new TextMapController(this.mainfunc.getMap()) );
        this.setFurnacecontroller( new TextFurnaceController(this.mainfunc.getFurnace()) );
        this.setInventorycontroller( new TextInventoryController(this.mainfunc.getInventory()) );
    }

    public void updatePrinter(){
        for (MyController simpleController : this.controllerslist) {
            ((TextControllerInterface) simpleController).updatePrinter();
        }
        this.tmc_helper.update(
                (MapPrinter) ((TextMapController) ((ArrayList<?>)this.controllerslist).get(0)).getPrinter() ,
                (FurnacePrinter) ((TextFurnaceController) ((ArrayList<?>)this.controllerslist).get(1)).getPrinter() ,
                (InventoryPrinter) ((TextInventoryController) ((ArrayList<?>)this.controllerslist).get(2)).getPrinter()
        );
        this.tmc_helper.updatePrinter();
    }
    public void redraw() {
        this.updatePrinter();
        this.tmc_helper.redraw();
    }
    public TextPrinter getPrinter() {
        return this.tmc_helper.tp;
    }

    public void smelt() {
        this.mainfunc.smelt();
    }
    public MainGUI getMainGUI() {
        return null;
    }
    public void move_from_furnace_to_inventory() {
        this.mainfunc.move_into_inventory_from_furnace();
    }
    public void move_from_inventory_to_furnace(int index) {
        this.mainfunc.move_into_furnace_from_inventory(index);
    }
    public void pick_block(MapCoordinates c) {
        this.mainfunc.pick_up_block(c);
    }
    public void toggle_sort_inventory() {
        this.mainfunc.toggle_inventory_comparator();
    }
    public void add_random_block() {
        MapCoordinates c = MapCoordinates.randomCoords();
        this.mainfunc.add_random_block_at_coords(c);
    }
    public void change_cell_with_Sand(MapCoordinates c) {
        this.mainfunc.change_cell_with_Sand(c);
    }
    public void move_into_furnace_from_map(MapCoordinates c) {
        this.mainfunc.move_into_furnace_from_map(c);
    }

}
