package controller;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import model.Medicina;
import model.Ripetibile;
import model.User;
import model.exceptions.*;
import view.MainGui;

public class BuyHandler implements EventHandler<MouseEvent> {
    private User user;
    private Medicina medicina;
    private MainGui mainGui;

    public BuyHandler(User user, Medicina medicina, MainGui mainGui) {
        this.user = user;
        this.medicina = medicina;
        this.mainGui = mainGui;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        try {
            medicina.buy(this.user);
        } catch (MoneyException | RicettaNonSelezionata | RipetibileException | RicettaMancanteException | ExpiredException e) {
            this.setAlert(e);
        } catch (RicettaException r) {}
        this.mainGui.refresh();
        this.mainGui.clearCenter();
    }

    private void setAlert(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        if (e instanceof MoneyException) {
            alert.setHeaderText("Soldi insufficienti");
        } else if (e instanceof ExpiredException) {
            alert.setHeaderText("Questo medicinale e' scaduto");
        } else if (e instanceof RicettaMancanteException) {
            alert.setHeaderText("Ricetta mancante");
        } else if (e instanceof RicettaNonSelezionata) {
            alert.setHeaderText("Ricetta non selezionata");
        } else if (e instanceof RipetibileException) {
            alert.setHeaderText("Hai superato il limite di utilizzi della ricetta");
        }
        alert.show();
    }
}
