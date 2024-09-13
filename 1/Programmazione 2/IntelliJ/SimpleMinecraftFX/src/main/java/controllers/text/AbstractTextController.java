package controllers.text;

import controllers.SimpleController;
import visual.printer.TextPrinter;

abstract public class AbstractTextController implements TextControllerInterface {
    TextPrinter tp;

    public TextPrinter getTextPrinter() {
        return this.tp;
    }

    public void redraw(){
        this.updatePrinter();
        this.tp.display_on_out();
    }
}
