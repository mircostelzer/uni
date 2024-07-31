package controller.textual;

import view.textual.TextPrinter;

public abstract class AbstractTextController implements TextControllerInterface {
    TextPrinter tp;

    public void redraw(){
        this.updatePrinter();
        tp.display_on_out();
    }
    public TextPrinter getPrinter(){
        return tp;
    }
}
