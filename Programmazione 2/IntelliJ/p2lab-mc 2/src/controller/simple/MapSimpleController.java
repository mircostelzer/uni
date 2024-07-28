package controller.simple;

import data.model.Map;
import utils.MapCoordinates;
import view.GUI.MapPane;

public class MapSimpleController implements SimpleController {
    private Map m;
    private MapPane mp;

    MapSimpleController(Map m, MapPane mp){
        this.m = m;
        this.mp = mp;
        redraw();
    }
    public void redraw(){
        for (int i = 0 ; i < MapCoordinates.DIMENSION_ROWS ; i++){
            for (int k = 0; k < MapCoordinates.DIMENSION_COLUMNS ; k++){
                MapCoordinates c = new MapCoordinates(i,k);
                mp.setCell(c, m.getCell(c));
            }
        }
    }
}
