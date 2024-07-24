package visual.GUI;

import javafx.scene.layout.BorderPane;

public class MainGui extends BorderPane {
    private MapPane mapPane;
    private ButtonListPane buttons;
    private FurnacePane furnacePane;
    private InventoryPane inventoryPane;

    public MainGui() {
        super();
        mapPane = new MapPane();
        buttons = new ButtonListPane(this);
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
}
