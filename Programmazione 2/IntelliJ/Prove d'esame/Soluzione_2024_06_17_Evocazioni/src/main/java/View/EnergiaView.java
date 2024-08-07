package View;

import Controller.MainGUI;
import Model.AlertDisplayer;
import Model.Evocazione.Energia;
import Model.Giocatore;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

/**
 * La classe EnergiaView estende StackPane e rappresenta la visualizzazione di una singola energia nel gioco.
 */
public class EnergiaView extends StackPane {
    private Giocatore giocatore;

    /**
     * Costruttore per creare una nuova visualizzazione di una energia.
     *
     * @param energia L'energia da visualizzare.
     * @param giocatore Il giocatore a cui appartiene l'energia.
     * @param evocazioniGiocatore La visualizzazione delle evocazioni del giocatore.
     * @param energieGiocatore La visualizzazione delle energie del giocatore.
     * @param mg L'istanza del controller MainGUI.
     */
    public EnergiaView(Energia energia, Giocatore giocatore, EvocazioniGiocatore evocazioniGiocatore, EnergieGiocatore energieGiocatore, MainGUI mg) {
        super();
        this.giocatore = giocatore;
        Rectangle r = new Rectangle(70, 30);
        r.setFill(energia.getColore());
        setAction(energia, evocazioniGiocatore, energieGiocatore, mg);
        getChildren().add(r);
    }

    /**
     * Imposta l'azione da eseguire quando si fa clic sull'energia.
     *
     * @param energia L'energia su cui si fa clic.
     * @param evocazioniGiocatore La visualizzazione delle evocazioni del giocatore.
     * @param energieGiocatore La visualizzazione delle energie del giocatore.
     * @param mg L'istanza del controller MainGUI.
     */
    private void setAction(Energia energia, EvocazioniGiocatore evocazioniGiocatore, EnergieGiocatore energieGiocatore, MainGUI mg){
        setOnMouseClicked(event -> {
            if(giocatore.isTurno() == MainGUI.isTurno()){
                Energia energiaEvocazione = giocatore.getEvocazioni().get(0).getTipo();
                if(energiaEvocazione.equals(energia) || energia.equals(Energia.NEUTRA)){
                    giocatore.getEnergie().remove(energia);
                    giocatore.getEvocazioni().get(0).incrementaEnergieAssegnate();
                    energieGiocatore.creaEnergieGiocatore(evocazioniGiocatore, mg);
                    evocazioniGiocatore.creaEvocazioniGiocatore(mg);
                } else {
                    AlertDisplayer.display_ERROR_alert("Evocazione tipo " + energiaEvocazione + " non compatibile con " + energia);
                }
            } else {
                AlertDisplayer.display_ERROR_alert("Questa energia è dell'avversario, non puoi usarla");
            }
        });
    }
}
