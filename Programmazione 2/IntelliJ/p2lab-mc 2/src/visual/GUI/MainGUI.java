package visual.GUI;

import controller.MainController;
import javafx.scene.layout.BorderPane;

public class MainGUI extends BorderPane {
    private MapPane g;
    private ButtonListPane bl;
    private InventoryPane ib;
    private FurnacePane fp;

//    public MainGUI(MainController mc){
    public MainGUI(){
        super();
        g = new MapPane();
        super.setCenter(g);
//        bl = new ButtonListPane(mc);
        bl = new ButtonListPane(this);
        super.setLeft(bl);
        ib = new InventoryPane();
        super.setTop(ib);
        fp = new FurnacePane();
        super.setRight(fp);
    }

    public MapPane getMapPane(){
        return g;
    }
    public InventoryPane getInventoryPane() {
        return this.ib;
    }
    public FurnacePane getFurnacePane(){
        return this.fp;
    }
}
