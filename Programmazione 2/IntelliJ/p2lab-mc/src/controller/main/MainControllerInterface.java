package controller.main;

import controller.MyController;
import utils.MapCoordinates;
import utils.NoGuiException;
import view.GUI.MainGUI;

public interface MainControllerInterface extends MyController {
    void smelt();
    void move_from_furnace_to_inventory();
    void move_from_inventory_to_furnace(int index);
    void pick_block(MapCoordinates c);
    void toggle_sort_inventory();
    void add_random_block();
     MainGUI getMainGUI() throws NoGuiException;
}
