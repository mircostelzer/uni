package visual.GUI;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

import javax.swing.*;

public class ExtListener implements EventHandler<ActionEvent> {
    private MapBlockPane mbp;

    public ExtListener(MapBlockPane mbp) {
        this.mbp = mbp;
    }

    public void handle(ActionEvent event) {

    }
}
