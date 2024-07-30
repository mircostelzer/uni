package visual.GUI;

import Utils.Coordinates;
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
        mainController.mine(1, coords);
        mapBlockPane.opacityProperty().add(-0.2);
        mainController.redraw();
    }
}
