package controller.simple;

import data.model.Furnace;
import view.GUI.BlockPane;
import view.GUI.FurnacePane;

public class FurnaceSimpleController implements SimpleController {
    private Furnace f;
    private FurnacePane fp;
    private MainSimpleController mc;

    FurnaceSimpleController(Furnace m, FurnacePane mp, MainSimpleController mc){
        this.f = m;
        this.fp = mp;
        this.mc = mc;
        redraw();
    }
    public void redraw(){
        fp.getChildren().clear();
        fp.addText();
        fp.getChildren().add(new BlockPane(f.get_furnaceInput()));
        fp.addArrow();
        fp.getChildren().add(new BlockPane(f.get_furnaceOutput()));
    }
}
