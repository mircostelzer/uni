package controller;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import model.Energy;
import model.Player;
import model.evocations.AbstractEvocation;
import model.exceptions.InsufficientEnergiesException;
import model.exceptions.WrongEnergyException;
import view.EnergiesPane;
import view.EvocationPane;
import view.MainGui;
import view.PlayerEvocPane;

public class Controller {
    private Player currentPlayer;
    private Player opponentPlayer;
    private MainGui mainGui;

    public Controller(Player currentPlayer, Player opponentPlayer) {
        this.currentPlayer = currentPlayer;
        this.opponentPlayer = opponentPlayer;
        mainGui = new MainGui(currentPlayer, opponentPlayer, this);

    }

    public void swapPlayers() {
        Player temp = currentPlayer;
        currentPlayer = opponentPlayer;
        opponentPlayer = temp;
        mainGui.swapPlayers();
    }

    public void attack(AbstractEvocation evocation) {
        try {
            currentPlayer.attack(opponentPlayer, evocation);
            if (opponentPlayer.hasLost()) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Game Over!");
                alert.setHeaderText(currentPlayer + " won!");
            } else {
                swapPlayers();
            }
        } catch (InsufficientEnergiesException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("You don't have enough energies!");
            alert.show();
        }
    }

    public void addEnergy(Energy energy) {
        try {
            currentPlayer.getEvocations().get(0).addEnergy(energy);
            currentPlayer.getEnergies().remove(energy);
            mainGui.redraw();
        } catch (WrongEnergyException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("You can't assign this energy!");
            alert.show();
        }
    }

    public MainGui getMainGui() {
        return mainGui;
    }

    public boolean isCurrentPlayer(Node node) {
        if (node instanceof PlayerEvocPane) {
            return ((PlayerEvocPane)node).getPlayer().equals(currentPlayer);
        } else if (node instanceof EnergiesPane) {
            return ((EnergiesPane)node).getPlayer().equals(currentPlayer);
        }
        return false;
    }

}
