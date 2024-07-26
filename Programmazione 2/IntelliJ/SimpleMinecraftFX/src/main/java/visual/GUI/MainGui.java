package visual.GUI;

import Controllers.MainSimpleController;
import javafx.scene.layout.BorderPane;
import visual.textual.MainView;

public class MainGui extends BorderPane {
    private MapPane mapPane;
    private ButtonListPane buttons;
    private FurnacePane furnacePane;
    private InventoryPane inventoryPane;
    private MainSimpleController mainController;

    public MainGui(MainSimpleController mainController) {
        super();
        this.mainController = mainController;
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

    public ButtonListPane getButtons() {
        return this.buttons;
    }

    public FurnacePane getFurnacePane() {
        return this.furnacePane;
    }

    public InventoryPane getInventoryPane() {
        return this.inventoryPane;
    }

    public MainSimpleController getMainController() {
        return this.mainController;
    }
}
