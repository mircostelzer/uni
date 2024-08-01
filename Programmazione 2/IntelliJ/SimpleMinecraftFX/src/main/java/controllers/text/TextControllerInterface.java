package controllers.text;

import controllers.SimpleController;
import visual.printer.TextPrinter;

public interface TextControllerInterface extends SimpleController {

    void updatePrinter();
    TextPrinter getTextPrinter();
}
