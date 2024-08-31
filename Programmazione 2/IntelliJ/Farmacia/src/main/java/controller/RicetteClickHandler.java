package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Ricetta;
import view.MainGui;

public class RicetteClickHandler implements EventHandler<MouseEvent> {
    private Ricetta ricetta;
    private MainGui mainGui;

    public RicetteClickHandler(MainGui mainGui, Ricetta ricetta) {
        this.ricetta = ricetta;
        this.mainGui = mainGui;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        ricetta.select();
        mainGui.refresh();
    }
}
