package view;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.Player;

public class GameOverPane extends VBox {
    private Player player;
    private Text points;
    private Text GameOver;

    public GameOverPane(Player player) {
        this.player = player;
        this.setSpacing(5);
        this.setAlignment(Pos.CENTER);
        this.redraw();
    }

    public void redraw() {
        this.getChildren().clear();
        points = new Text("Points: "+player.getPoints());
        points.setFont(new Font("Verdana", 15));
        GameOver = new Text("GAME OVER");
        GameOver.setFont(Font.font("Verdana", FontWeight.BOLD , 15));

        this.getChildren().addAll(points, GameOver);
    }
}
