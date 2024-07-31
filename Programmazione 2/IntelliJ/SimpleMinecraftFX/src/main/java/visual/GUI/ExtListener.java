package visual.GUI;

import Utils.Coordinates;
import controllers.MainControllerInterface;
import controllers.MainSimpleController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

import javax.swing.*;

public class ExtListener implements EventHandler<MouseEvent> {
    MainSimpleController mainController;
    Coordinates coords;
    MapBlockPane mapBlockPane;

    public ExtListener(MainSimpleController mainController, Coordinates coords, MapBlockPane mapBlockPane) {
        this.mainController = mainController;
        this.coords = coords;
        this.mapBlockPane = mapBlockPane;
    }

    public void handle(MouseEvent event) {
        if (this.mainController.getMainGui().is_active()) {
            mainController.mine(2, coords);
        }
        else {
            mainController.mine(1, coords);
        }
    }
}
