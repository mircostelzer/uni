package controllers;

import Utils.Coordinates;
import Utils.WrongCoordinatesException;
import data.blocks.interfaces.Block;
import visual.GUI.MapPane;
import visual.textual.Map;

public class MapSimpleController implements SimpleController {
    private Map map;
    private MapPane mapPane = new MapPane();

    public MapSimpleController(Map map, MapPane mapPane) {
        this.map = map;
        this.mapPane = mapPane;
        this.redraw();
    }

    public void redraw() {
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
}
