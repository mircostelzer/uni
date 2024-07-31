package controllers.fine_grained;

import java.util.Collection;

public interface FGController {
    void efficient_redraw();
    void not_efficient_redraw();
    void add_efficiency_enabler(Object o);
    Collection<Object> get_efficiency_enabler();
}
