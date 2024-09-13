package controllers.fine_grained;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractFGController implements FGController {
    protected Collection<Object> efficiency_enablers;

    public AbstractFGController() {
        this.efficiency_enablers = new ArrayList<Object>();
    }

    public void redraw() {
        if (efficiency_enablers.isEmpty()) {
            this.not_efficient_redraw();
        }
        else {
            this.efficient_redraw();
            this.efficiency_enablers.clear();
        }
    }

    public abstract void efficient_redraw();

    public abstract void not_efficient_redraw();

    public void add_efficiency_enabler(Object o) {
        this.efficiency_enablers.add(o);
    }

    public Collection<Object> get_efficiency_enabler() {
        return this.efficiency_enablers;
    }
}
