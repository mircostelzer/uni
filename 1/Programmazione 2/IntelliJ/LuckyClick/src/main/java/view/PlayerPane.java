package view;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Player;

public class PlayerPane extends VBox {
    private Text points;
    private Text tries;
    private Player player;

    public PlayerPane(Player player) {
        this.player = player;
        this.redraw();
    }

    public void redraw() {
        this.getChildren().clear();
        points = new Text("Points: " + player.getPoints());
        tries = new Text("Tries: " + player.getTries());
        getChildren().addAll(points, tries);
        this.setSpacing(5);
        this.setAlignment(Pos.CENTER);
    }
}
