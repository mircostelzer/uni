package controllers.text;

import visual.printer.MapPrinter;
import visual.textual.Map;

public class MapTextController extends AbstractTextController {
    private Map map;

    public MapTextController(Map map) {
        this.map = map;
        this.tp = new MapPrinter();
    }

    @Override
    void updatePrinter() {
        ((MapPrinter)this.tp).update(this.map.getGrid(), Map.DEFAULT_ROWS, Map.DEFAULT_COLUMNS);

    }
}
