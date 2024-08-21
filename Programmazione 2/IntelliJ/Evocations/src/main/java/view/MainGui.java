package view;

import controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import model.Player;
import java.util.*;

public class MainGui extends BorderPane {
    private Player currentPlayer;
    private Player opponentPlayer;
    private PlayerEvocPane currPlayerEvocationPane;
    private PlayerEvocPane opponentEvocationPane;
    private EnergiesPane currPlayerEnergiesPane;
    private EnergiesPane opponentEnergiesPane;

    public MainGui(Player currentPlayer, Player opponentPlayer, Controller controller) {
        this.currentPlayer = currentPlayer;
        this.opponentPlayer = opponentPlayer;
        currPlayerEvocationPane = new PlayerEvocPane(currentPlayer, controller);
        opponentEvocationPane = new PlayerEvocPane(opponentPlayer, controller);
        currPlayerEnergiesPane = new EnergiesPane(currentPlayer, controller);
        opponentEnergiesPane = new EnergiesPane(opponentPlayer, controller);

        this.setTop(opponentEvocationPane);
        opponentEvocationPane.setAlignment(Pos.CENTER_RIGHT);
        this.setLeft(currPlayerEnergiesPane);
        this.setRight(opponentEnergiesPane);
        this.setBottom(currPlayerEvocationPane);
        currPlayerEvocationPane.setAlignment(Pos.CENTER_LEFT);
    }

    public void redraw() {
        currPlayerEvocationPane.redraw();
        opponentEvocationPane.redraw();
        currPlayerEnergiesPane.redraw();
        opponentEnergiesPane.redraw();
    }

    public void swapPlayers() {
        Player temp = currentPlayer;
        currentPlayer = opponentPlayer;
        opponentPlayer = temp;
        currPlayerEvocationPane.swapPlayer(currentPlayer);
        opponentEvocationPane.swapPlayer(opponentPlayer);
        currPlayerEnergiesPane.swapPlayer(currentPlayer);
        opponentEnergiesPane.swapPlayer(opponentPlayer);
        this.redraw();
    }
}
