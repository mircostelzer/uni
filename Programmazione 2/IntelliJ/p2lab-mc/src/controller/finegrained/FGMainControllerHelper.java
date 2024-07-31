package controller.finegrained;

public class FGMainControllerHelper extends AbstractFGController{
    FGMainControllerHelper(){
        super();
    }

    public void efficient_redraw() {
    }
    public void not_efficient_redraw() {
    }

    public void add_efficiency_enabler(Object o) {
        this.efficiency_enablers.add(o);
    }
}
