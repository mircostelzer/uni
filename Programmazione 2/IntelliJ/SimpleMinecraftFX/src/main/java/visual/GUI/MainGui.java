package visual.GUI;

import controllers.MainSimpleController;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;

import java.awt.event.KeyEvent;

public class MainGui extends BorderPane {
    private MapPane mapPane;
    private ButtonListPane buttons;
    private FurnacePane furnacePane;
    private InventoryPane inventoryPane;

    public MainGui(MainSimpleController mainController) {
        super();
        mapPane = new MapPane(mainController);
        buttons = new ButtonListPane(mainController);
        furnacePane = new FurnacePane(mainController);
        inventoryPane = new InventoryPane(mainController);
        super.setCenter(mapPane);
        super.setLeft(buttons);
        super.setRight(furnacePane);
        super.setBottom(inventoryPane);
    }

    public MapPane getMapPane() {
        return this.mapPane;
    }

    public FurnacePane getFurnacePane() {
        return this.furnacePane;
    }

    public InventoryPane getInventoryPane() {
        return this.inventoryPane;
    }

}
