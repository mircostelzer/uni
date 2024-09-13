package view;

import controller.Controller;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import model.Energy;
import model.Player;

public class EnergiesPane extends VBox {
    private Player player;
    private Controller controller;


    public EnergiesPane(Player player, Controller controller) {
        this.player = player;
        this.controller = controller;
        this.setSpacing(10);
        this.redraw();
    }

    public void redraw() {
        this.getChildren().clear();
        for (Energy energy : player.getEnergies()) {
            Rectangle rectangle = new Rectangle(70, 30);
            rectangle.setFill(EvocationPane.getColor(energy));
            rectangle.setOnMouseClicked(e -> {
                if (controller.isCurrentPlayer(this)) {
                    controller.addEnergy(energy);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("You can't use this energy!");
                    alert.show();
                }
            });
            this.getChildren().add(rectangle);
        }
    }



    public void swapPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
