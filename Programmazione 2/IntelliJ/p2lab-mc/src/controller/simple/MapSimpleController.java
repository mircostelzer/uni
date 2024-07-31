package controller.simple;

import data.model.Map;
import utils.MapCoordinates;
import view.GUI.MapPane;

public class MapSimpleController implements SimpleController {
    private Map m;
    private MapPane mp;

    private MapCoordinates drawme;

    MapSimpleController(Map m, MapPane mp){
        this.m = m;
        this.mp = mp;
        drawme = null;
        redraw();
    }
    public void redraw(){
        if (drawme == null){
            for (int i = 0 ; i < MapCoordinates.DIMENSION_ROWS ; i++) {
                for (int k = 0; k < MapCoordinates.DIMENSION_COLUMNS; k++) {
                    MapCoordinates c = new MapCoordinates(i, k);
                    mp.setCell(c, m.getCell(c));
                }
            }
        }else{
            this.redraw_coord(drawme);
            drawme = null;
        }
    }

    public void set_drawme(MapCoordinates c){
        this.drawme = c;
    }

    private void redraw_coord(MapCoordinates c ){
        mp.setCell(c, m.getCell(c));
    }
}
