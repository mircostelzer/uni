package controller;

import data.blocks.interfaces.Block;
import javafx.scene.text.Text;
import visual.GUI.BlockPane;
import visual.GUI.InventoryPane;
import visual.textual.Inventory;

import java.util.Iterator;

public class InventoryController implements Controller{
    private Inventory i;
    private InventoryPane ip;

    InventoryController(Inventory m, InventoryPane mp){
        this.i = m;
        this.ip = mp;
        redraw();
    }

    public void redraw() {
        ip.getChildren().clear();
        ip.addText();
        Iterator<Block> it = i.get_inventory();
        while( it.hasNext() ){
            ip.getChildren().add(new BlockPane(it.next()));
            Text t = new Text(" - ");
            ip.getChildren().add(t);
        }
        if (ip.getChildren().size() > 1) {
            ip.getChildren().remove(ip.getChildren().size()-1);
        }
    }
}
