package controller.finegrained;

import controller.MyController;

import java.util.Collection;

public interface FGControllerInterface extends MyController {
    void efficient_redraw();
    void not_efficient_redraw();
    void add_efficiency_enabler(Object o);
    Collection<Object> get_efficiency_enabler();
}
