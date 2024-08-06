package view;

import controller.Controller;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Grid;
import model.Player;

public class MainGui extends BorderPane {
    private PlayerPane playerPane;
    private PlayGridPane playGridPane;
    private Player player;
    private Grid grid;

    public MainGui(Player player, Grid grid, Controller controller) {
        this.player = player;
        this.grid = grid;
        this.playerPane = new PlayerPane(this.player);
        this.playGridPane = new PlayGridPane(this.grid, controller);

        this.setTop(this.playerPane);
        this.setCenter(this.playGridPane);
    }

    public void redraw() {
        this.playerPane.redraw();
        this.playGridPane.redraw();
    }

    public Player getPlayer() {
        return this.player;
    }

    public Grid getGrid() {
        return this.grid;
    }

    public PlayerPane getPlayerPane() {
        return this.playerPane;
    }

    public PlayGridPane getPlayGridPane() {
        return this.playGridPane;
    }
}
