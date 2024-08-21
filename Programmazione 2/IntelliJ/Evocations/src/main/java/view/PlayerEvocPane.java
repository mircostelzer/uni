package view;

import controller.Controller;
import javafx.scene.layout.HBox;
import model.Player;
import model.evocations.AbstractEvocation;

public class PlayerEvocPane extends HBox {
    private Player player;
    private Controller controller;

    public PlayerEvocPane(Player player, Controller controller) {
        this.player = player;
        this.controller = controller;
        this.setSpacing(10);
        this.redraw();
    }

    public void redraw() {
        this.getChildren().clear();
        for (AbstractEvocation evocation : player.getEvocations()) {
            EvocationPane evocPane = new EvocationPane(evocation);
            evocPane.setOnMouseClicked(event -> {
                if (controller.isCurrentPlayer(this)) {
                    controller.attack(evocation);
                }
            });
            this.getChildren().add(evocPane);
        }
    }

    public void swapPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
