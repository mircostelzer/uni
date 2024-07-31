package controller.textual;

import controller.MyController;
import view.textual.TextPrinter;

public interface TextControllerInterface extends MyController {

    void updatePrinter();
    TextPrinter getPrinter();

}
