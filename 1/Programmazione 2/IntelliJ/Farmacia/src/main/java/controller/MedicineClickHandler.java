package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Farmacia;
import model.Medicina;
import view.MainGui;


public class MedicineClickHandler implements EventHandler<MouseEvent> {
    private Medicina medicina;
    private MainGui mainGui;

    public MedicineClickHandler(Medicina medicina, MainGui mainGui) {
        this.medicina = medicina;
        this.mainGui = mainGui;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        this.mainGui.setCenter(medicina);
    }
}
