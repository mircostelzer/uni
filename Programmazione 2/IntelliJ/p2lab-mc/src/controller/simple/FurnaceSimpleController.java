package controller.simple;

import data.model.Furnace;
import view.GUI.FurnacePane;
import view.GUI.clickablePanes.ClickableInternalBlockPane;

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
        fp.getChildren().add(new ClickableInternalBlockPane(f.get_furnaceInput(),mc));
        fp.addArrow();
        fp.getChildren().add(new ClickableInternalBlockPane(f.get_furnaceOutput(),mc));
    }
}
