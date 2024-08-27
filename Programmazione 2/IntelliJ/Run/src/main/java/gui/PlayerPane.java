package gui;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Player;

public class PlayerPane extends HBox {
    private Player player;
    private Text info;

    public PlayerPane(Player player) {
        this.player = player;
        this.setAlignment(Pos.CENTER);
        this.setPrefHeight(70);
        this.refresh();
    }

    public void refresh() {
        this.getChildren().clear();
        info = new Text(player.toString());
        info.setFont(new Font(15));
        this.getChildren().add(info);
    }
}
