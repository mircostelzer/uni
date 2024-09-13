package View;

import Controller.MainGUI;
import Model.Evocazione.Evocazione;
import Model.Giocatore;
import javafx.scene.layout.HBox;

/**
 * La classe EvocazioniGiocatore estende HBox e rappresenta la visualizzazione delle evocazioni di un giocatore.
 */
public class EvocazioniGiocatore extends HBox {
    private Giocatore giocatore;

    /**
     * Costruttore per creare la visualizzazione delle evocazioni di un giocatore.
     *
     * @param giocatore Il giocatore di cui visualizzare le evocazioni.
     * @param mg L'istanza del controller MainGUI.
     */
    public EvocazioniGiocatore(Giocatore giocatore, MainGUI mg) {
        super();
        this.giocatore = giocatore;
        creaEvocazioniGiocatore(mg);
    }

    /**
     * Crea e aggiorna la visualizzazione delle evocazioni del giocatore.
     *
     * @param mg L'istanza del controller MainGUI.
     */
    public void creaEvocazioniGiocatore(MainGUI mg) {
        getChildren().clear();
        for (Evocazione evocazione : giocatore.getEvocazioni()) {
            getChildren().add(new EvocazioneView(evocazione, giocatore, mg, this));
        }
        setSpacing(10);
    }
}
