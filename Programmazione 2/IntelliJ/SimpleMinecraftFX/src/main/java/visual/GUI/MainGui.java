package visual.GUI;

import controllers.MainSimpleController;
import javafx.scene.layout.BorderPane;

public class MainGui extends BorderPane {
    private MapPane mapPane;
    private ButtonListPane buttons;
    private FurnacePane furnacePane;
    private InventoryPane inventoryPane;

    public MainGui(MainSimpleController mainController) {
        super();
        mapPane = new MapPane();
        buttons = new ButtonListPane(mainController);
        furnacePane = new FurnacePane();
        inventoryPane = new InventoryPane();
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
