package controllers.fine_grained;

import Utils.Coordinates;
import Utils.WrongCoordinatesException;
import data.blocks.interfaces.Block;
import visual.GUI.MapPane;
import visual.textual.Map;

import java.util.Collection;
import java.util.Iterator;

public class FGMapController extends AbstractFGController {
    private Map map;
    private MapPane mapPane;

    public FGMapController(Map map, MapPane mapPane) {
        super();
        this.map = map;
        this.mapPane = mapPane;
        this.redraw();
    }

    @Override
    public void efficient_redraw() {
        for (Iterator<Object> it = efficiency_enablers.iterator(); it.hasNext(); ) {
            Coordinates c = (Coordinates) it.next();
            try {
                Block b = map.getBlock(c);
                mapPane.setCell(b, c);
            }
            catch (WrongCoordinatesException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void not_efficient_redraw() {
        this.mapPane.getChildren().clear();
        Block b = null;
        for (int i=0; i<Map.DEFAULT_COLUMNS; i++) {
            for (int j=0; j<Map.DEFAULT_ROWS; j++) {
                try {
                    b = this.map.getBlock(new Coordinates(j, i));
                }
                catch (WrongCoordinatesException e) {
                    e.printStackTrace();
                }
                this.mapPane.setCell(b, new Coordinates(j, i));
            }
        }
    }

    public void add_efficiency_enabler(Object o) {
        if (o instanceof Coordinates) {
            efficiency_enablers.add(o);
        }
    }
}
