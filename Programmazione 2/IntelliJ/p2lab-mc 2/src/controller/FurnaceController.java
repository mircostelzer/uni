package controller;

import visual.GUI.BlockPane;
import visual.GUI.FurnacePane;
import visual.textual.Furnace;

public class FurnaceController implements Controller{
    private Furnace f;
    private FurnacePane fp;

    FurnaceController(Furnace m, FurnacePane mp){
        this.f = m;
        this.fp = mp;
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
