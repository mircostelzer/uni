package controllers.text;

import visual.printer.TextPrinter;

abstract public class AbstractTextController {
    TextPrinter tp;

    public TextPrinter getTextPrinter() {
        return this.tp;
    }

    abstract void updatePrinter();

    public void update_and_display(){
        this.updatePrinter();
        this.tp.display_on_out();
    }
}
