package controllers;

import Utils.Coordinates;
import visual.GUI.MainGui;

public interface MainControllerInterface {
    void smelt();
    void move_into_inventory_from_furnace();
    void move_into_furnace_from_inventory(int i);
    void pick_up_block(Coordinates coordinates);
    void toggle_inventory_comparator();
}
