package Main.controller;

import Main.model.Giocatore;
import Main.model.exceptions.GameOverException;
import Main.model.exceptions.WrongEnergiesException;
import Main.view.EvocazionePane;
import Main.view.MainView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

public class EvocazioneController implements EventHandler<MouseEvent> {

    private EvocazionePane ep ;
    private Giocatore g;
    private MainView mv;

    public EvocazioneController(EvocazionePane ep, Giocatore g, MainView mv){
        this.ep = ep;
        this.g = g;
        this.mv = mv;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mv.is_g1(this.g)){
            if (g.getEvocazioneAttiva() == this.ep.getEvocazione() ){
                try {
                    this.g.attacca();
                    mv.flipPlayers();
                    mv.refresh();
                } catch (WrongEnergiesException e) {
                    Alert a = new Alert(AlertType.ERROR);
                    a.setContentText("Energie Errate");
                    a.show();
                } catch (GameOverException e) {
                    Alert a = new Alert(AlertType.CONFIRMATION);
                    a.setContentText("Game over");
                    a.showAndWait();
                    System.exit(1);
                }
            }else{
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("Evoluzione Errata");
                a.show();
            }
        }else{
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Giocatore Errato");
            a.show();
        }
    }
}
