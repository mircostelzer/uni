package view;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import model.Player;
import model.evocations.AbstractEvocation;

public class CurrPlayerEvoc extends HBox {
    private Player player;

    public CurrPlayerEvoc(Player player) {
        this.player = player;
        this.setSpacing(10);
    }

    public void redraw() {
        this.getChildren().clear();
        for (AbstractEvocation evocation : player.getEvocations()) {

        }
    }
}
