package controller.finegrained;

import controller.main.MainControllerInterface;
import data.model.Furnace;
import view.GUI.FurnacePane;
import view.GUI.clickablePanes.ClickableInternalBlockPane;

public class FGFurnaceController extends AbstractFGController {
    private Furnace f;
    private FurnacePane fp;
    private MainControllerInterface mc;

    FGFurnaceController(Furnace m, FurnacePane mp, MainControllerInterface mc){
        super();
        this.f = m;
        this.fp = mp;
        this.mc = mc;
        redraw();
    }

    public void efficient_redraw() {
        this.not_efficient_redraw();
    }
    public void not_efficient_redraw(){
        fp.getChildren().clear();
        fp.addText();
        fp.getChildren().add(new ClickableInternalBlockPane(f.get_furnaceInput(),mc));
        fp.addArrow();
        fp.getChildren().add(new ClickableInternalBlockPane(f.get_furnaceOutput(),mc));
    }

    public void add_efficiency_enabler(Object o) {
        return;
    }
}
