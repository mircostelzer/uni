package visual.GUI;

import data.blocks.interfaces.Block;
import javafx.event.Event;
import javafx.event.EventHandler;

public class FurnaceBlockPane extends BlockPane {

    public FurnaceBlockPane(Block b) {
        super(b);
    }

    class IntListener implements EventHandler<Event> {

        @Override
        public void handle(Event event) {

        }
    }
}
