package view.GUI;

import controller.main.MainControllerInterface;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import view.GUI.handlers.BlockPaneClickHandlerFactory;

public class MainGUI extends BorderPane {
    private MapPane g;
    private ButtonListPane bl;
    private InventoryPane ib;
    private FurnacePane fp;

    private BlockPaneClickHandlerFactory bcphf;

    public MainGUI(MainControllerInterface mc){
        super();
        bcphf = new BlockPaneClickHandlerFactory(mc);
        g = new MapPane(bcphf);
        super.setCenter(g);
        bl = new ButtonListPane(mc);
        super.setLeft(bl);
        ib = new InventoryPane();
        super.setTop(ib);
        fp = new FurnacePane();
        super.setRight(fp);
        super.addEventHandler(KeyEvent.KEY_PRESSED,new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case S:
                        mc.toggle_sort_inventory();
                        break;
                    case N:
                        mc.add_random_block();
                        break;
                    case R:
                        for(int i = 0 ; i < 10 ; i++){
                            mc.add_random_block();
                        }
                        break;
                    default:
                        // alert
                        break;
                }
            }
        });
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
