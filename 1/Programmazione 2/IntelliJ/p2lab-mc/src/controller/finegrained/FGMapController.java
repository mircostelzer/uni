package controller.finegrained;

import data.model.Map;
import utils.MapCoordinates;
import view.GUI.MapPane;

import java.util.Iterator;

public class FGMapController extends AbstractFGController {
    private Map m;
    private MapPane mp;

    FGMapController(Map m, MapPane mp){
        super();
        this.m = m;
        this.mp = mp;
        redraw();
    }

    public void add_efficiency_enabler(Object o){
        if (o instanceof MapCoordinates){
            this.efficiency_enablers.add(o);
        }
    }
    public void efficient_redraw() {
        Iterator<Object> i = this.efficiency_enablers.iterator();
        while (i.hasNext()){
            MapCoordinates c = (MapCoordinates) i.next();
            mp.setCell(c, m.getCell(c));
        }
    }
    public void not_efficient_redraw() {
        for (int i = 0 ; i < MapCoordinates.DIMENSION_ROWS ; i++) {
            for (int k = 0; k < MapCoordinates.DIMENSION_COLUMNS; k++) {
                MapCoordinates c = new MapCoordinates(i, k);
                mp.setCell(c, m.getCell(c));
            }
        }
    }
}
