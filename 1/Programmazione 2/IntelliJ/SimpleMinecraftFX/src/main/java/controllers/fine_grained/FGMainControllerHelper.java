package controllers.fine_grained;

public class FGMainControllerHelper extends AbstractFGController {

    FGMainControllerHelper() {
        super();
    }
    @Override
    public void efficient_redraw() {

    }

    @Override
    public void not_efficient_redraw() {

    }

    public void add_efficiency_enabler(Object o) {
        this.efficiency_enablers.add(o);
    }
}
