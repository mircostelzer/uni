package controller.finegrained;

import utils.MapCoordinates;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractFGController implements FGControllerInterface {
    protected Collection<Object> efficiency_enablers;

    protected AbstractFGController(){
        this.efficiency_enablers = new ArrayList<Object>();
    }

    public abstract void efficient_redraw();
    public abstract void not_efficient_redraw();

    public void add_efficiency_enabler(Object o){
        this.efficiency_enablers.add(o);
    }
    public final void redraw() {
        if (efficiency_enablers.size() > 0){
            this.efficient_redraw();
            this.efficiency_enablers.clear();
        }else{
            this.not_efficient_redraw();
        }
    }
    public Collection<Object> get_efficiency_enabler(){
        return efficiency_enablers;
    }
}
