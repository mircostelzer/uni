package controller.textual;

import view.textual.TextPrinter;

public abstract class AbstractTextController {
    TextPrinter tp;

    abstract void updatePrinter();

    public void update_and_display(){
        this.updatePrinter();
        tp.display_on_out();
    }
    public TextPrinter getPrinter(){
        return tp;
    }
}
