package Main.controller;

import Main.model.Giocatore;
import Main.model.exceptions.IncompatibleEnergyException;
import Main.view.EnergyPane;
import Main.view.MainView;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

public class EnergyController implements EventHandler<MouseEvent> {

    private EnergyPane ep ;
    private Giocatore g;
    private MainView mv;

    public EnergyController(EnergyPane ep, Giocatore g, MainView mv){
        this.ep = ep;
        this.g = g;
        this.mv = mv;
    }

    public void handle(MouseEvent keyEvent) {
        if (mv.is_g1(this.g)){
            if (keyEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
                try {
                    g.assegnaEnergia(ep.getEnergia());
                } catch (IncompatibleEnergyException e) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("Energie Incompatibili");
                    a.show();
                }
                mv.refresh();
            }
        }else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Giocatore Errato");
            a.show();
        }
    }
}
