package View;

import Controller.MainGUI;
import Model.Evocazione.Energia;
import Model.Giocatore;
import javafx.scene.layout.VBox;

/**
 * La classe EnergieGiocatore estende VBox e rappresenta la visualizzazione delle energie di un giocatore.
 */
public class EnergieGiocatore extends VBox {
    private Giocatore giocatore;

    /**
     * Costruttore per creare la visualizzazione delle energie di un giocatore.
     *
     * @param giocatore Il giocatore di cui visualizzare le energie.
     * @param evocazioniGiocatore La visualizzazione delle evocazioni del giocatore.
     * @param mg L'istanza del controller MainGUI.
     */
    public EnergieGiocatore(Giocatore giocatore, EvocazioniGiocatore evocazioniGiocatore, MainGUI mg) {
        super();
        this.giocatore = giocatore;
        creaEnergieGiocatore(evocazioniGiocatore, mg);
    }

    /**
     * Crea e aggiorna la visualizzazione delle energie del giocatore.
     *
     * @param evocazioniGiocatore La visualizzazione delle evocazioni del giocatore.
     * @param mg L'istanza del controller MainGUI.
     */
    public void creaEnergieGiocatore(EvocazioniGiocatore evocazioniGiocatore, MainGUI mg){
        getChildren().clear();
        for (Energia energia : giocatore.getEnergie()) {
            getChildren().add(new EnergiaView(energia, giocatore, evocazioniGiocatore, this, mg));
        }
        setSpacing(10);
    }
}
