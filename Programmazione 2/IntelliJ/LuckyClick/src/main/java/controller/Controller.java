package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Grid;
import model.Player;
import view.CellPane;
import view.MainGui;
import view.PlayGridPane;
import view.PlayerPane;


public class Controller implements EventHandler<MouseEvent> {
    private Grid grid;
    private Player player;
    private MainGui mainGui;

    public Controller(Grid grid, Player player) {
        this.grid = grid;
        this.player = player;
        this.mainGui = new MainGui(this.player, this.grid, this);
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        if (player.getTries() > 0) {
            CellPane clicked = (CellPane) mouseEvent.getSource();
            if (!this.grid.getCellAtCoords(PlayGridPane.getRowIndex(clicked), PlayGridPane.getColumnIndex(clicked)).isActive()) {
                player.setTries(player.getTries() - 1);
            }
            this.grid.reveal(PlayGridPane.getRowIndex(clicked), PlayGridPane.getColumnIndex(clicked));
            this.mainGui.redraw();
        }
    }

    public MainGui getMainGui() {
        return this.mainGui;
    }
}
