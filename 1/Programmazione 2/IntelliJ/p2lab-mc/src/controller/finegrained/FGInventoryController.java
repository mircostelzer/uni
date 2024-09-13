package controller.finegrained;

import controller.main.MainControllerInterface;
import data.blocks.interfaces.Block;
import data.blocks.utils.AlphabeticalBlockComparator;
import data.blocks.utils.BlockComparator;
import data.model.Inventory;
import javafx.scene.text.Text;
import view.GUI.InventoryPane;
import view.GUI.clickablePanes.ClickableAnonymousBlockPane;

import java.util.Comparator;
import java.util.Iterator;

public class FGInventoryController extends AbstractFGController {
    private Inventory i;
    private InventoryPane ip;

    private MainControllerInterface mc;

    FGInventoryController(Inventory m, InventoryPane mp, MainControllerInterface mc){
        super();
        this.i = m;
        this.ip = mp;
        this.mc = mc;
        redraw();
    }

    public void efficient_redraw() {
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

    @Override
    public void not_efficient_redraw() {
        this.efficient_redraw();
    }

    @Override
    public void add_efficiency_enabler(Object o) {
        return;
    }
}
