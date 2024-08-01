package controllers.fine_grained;

import controllers.SimpleController;

import java.util.Collection;

public interface FGController extends SimpleController {
    void efficient_redraw();
    void not_efficient_redraw();
    void add_efficiency_enabler(Object o);
    Collection<Object> get_efficiency_enabler();
}
