package sampleFX;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickListener implements EventHandler<MouseEvent> {
    private Controller controller;
    private int x;
    private int y;

    public ClickListener(Controller controller, int x, int y) {
        this.controller = controller;
        this.x = x;
        this.y = y;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        this.controller.move(this.x, this.y, "X");
        try {
            this.controller.wait(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.controller.computer();
    }
}
