package controller.simple;

import data.blocks.interfaces.Block;
import data.blocks.utils.AlphabeticalBlockComparator;
import data.blocks.utils.BlockComparator;
import data.model.Inventory;
import javafx.scene.text.Text;
import view.GUI.BlockPane;
import view.GUI.InventoryPane;
import controller.textual.TextInventoryController;
import view.GUI.clickablePanes.ClickableAnonymousBlockPane;

import java.util.Comparator;
import java.util.Iterator;

public class InventorySimpleController implements SimpleController {
    private Inventory i;
    private InventoryPane ip;

    private MainSimpleController mc;

    InventorySimpleController(Inventory m, InventoryPane mp, MainSimpleController mc){
        this.i = m;
        this.ip = mp;
        this.mc = mc;
        redraw();
    }

    public void redraw() {
        ip.getChildren().clear();
        String tt = null;
        Comparator<Block> cb = i.get_comparator();
        if (cb instanceof BlockComparator){
            tt = "t";
        }else if (cb instanceof AlphabeticalBlockComparator){
            tt = "a";
        }
        ip.addText(tt);
        Iterator<Block> it = i.get_inventory();
        int index = 0;
        while( it.hasNext() ){
            ip.getChildren().add(new ClickableAnonymousBlockPane(it.next(), mc, index));
            Text t = new Text(" - ");
            ip.getChildren().add(t);
            index ++;
        }
        if (ip.getChildren().size() > 1) {
            ip.getChildren().remove(ip.getChildren().size()-1);
        }
    }
}
