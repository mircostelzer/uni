package Controller;

import Model.Giocatore;
import View.EnergieGiocatore;
import View.EvocazioniGiocatore;

/**
 * La classe GiocatoreEnhanced rappresenta un giocatore arricchito con le visualizzazioni delle evocazioni e delle energie.
 */
public class GiocatoreEnhanced {
    private Giocatore giocatore;
    private EvocazioniGiocatore evocazioniGiocatore;
    private EnergieGiocatore energieGiocatore;

    /**
     * Costruttore per creare un GiocatoreEnhanced.
     *
     * @param giocatore Il giocatore da arricchire con le visualizzazioni.
     * @param mg L'istanza del controller MainGUI.
     */
    public GiocatoreEnhanced(Giocatore giocatore, MainGUI mg) {
        this.giocatore = giocatore;
        evocazioniGiocatore = new EvocazioniGiocatore(giocatore, mg);
        energieGiocatore = new EnergieGiocatore(giocatore, evocazioniGiocatore, mg);
    }

    /**
     * Restituisce il giocatore.
     *
     * @return Il giocatore.
     */
    public Giocatore getGiocatore() {
        return giocatore;
    }

    /**
     * Restituisce la visualizzazione delle evocazioni del giocatore.
     *
     * @return La visualizzazione delle evocazioni del giocatore.
     */
    public EvocazioniGiocatore getEvocazioniGiocatore() {
        return evocazioniGiocatore;
    }

    /**
     * Restituisce la visualizzazione delle energie del giocatore.
     *
     * @return La visualizzazione delle energie del giocatore.
     */
    public EnergieGiocatore getEnergieGiocatore() {
        return energieGiocatore;
    }
}
