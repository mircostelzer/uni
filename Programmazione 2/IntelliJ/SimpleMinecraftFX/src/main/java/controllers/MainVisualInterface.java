package controllers;

import Utils.Coordinates;
import visual.GUI.MainGui;

public interface MainVisualInterface extends MainControllerInterface {
    void mine(int n, Coordinates coords);
    MainGui getMainGui();
}
