package controller.textual;

import data.model.Map;
import view.textual.MapPrinter;

public class TextMapController extends AbstractTextController{
    Map m;

    TextMapController(Map m){
        this.m = m;
        this.tp = new MapPrinter();
    }

    public void updatePrinter() {
        ((MapPrinter) tp).update(this.m.getContent());
    }

}