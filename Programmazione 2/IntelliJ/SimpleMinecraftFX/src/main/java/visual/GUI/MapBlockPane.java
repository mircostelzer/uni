package visual.GUI;

import Utils.Coordinates;
import controllers.MainSimpleController;
import data.blocks.NullBlock;
import data.blocks.interfaces.Block;
import javafx.beans.property.Property;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.awt.*;

public class MapBlockPane extends BlockPane {
    MainSimpleController mainController;

    public MapBlockPane(Block b, MainSimpleController mainController, Coordinates coords) {
        super(b);
        this.mainController = mainController;
        this.setOnMouseClicked(new ExtListener(mainController, coords, this));
    }

}
