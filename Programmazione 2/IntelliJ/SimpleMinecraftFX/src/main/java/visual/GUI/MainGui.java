package visual.GUI;

import javafx.scene.layout.BorderPane;

public class MainGui extends BorderPane {
    private MapPane mapPane;
    private ButtonListPane buttons;
    private FurnacePane furnacePane;

    public MainGui() {
        super();
        mapPane = new MapPane();
        buttons = new ButtonListPane();
        furnacePane = new FurnacePane();
        super.setCenter(mapPane);
        super.setLeft(buttons);
        super.setRight(furnacePane);
    }
}
