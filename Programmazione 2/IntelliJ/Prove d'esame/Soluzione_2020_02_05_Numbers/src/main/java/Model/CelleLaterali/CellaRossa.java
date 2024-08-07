package Model.CelleLaterali;

import Model.CellaLaterale;
import View.CellePane;
import javafx.scene.paint.Color;

/**
 * Classe che rappresenta una cella laterale di colore rosso in una griglia o una plancia di gioco.
 * Estende la classe CellaLaterale e imposta il contenuto basato sul valore della colonna.
 */
public class CellaRossa extends CellaLaterale {

    /**
     * Costruttore della classe CellaRossa.
     * Inizializza la cella rossa con un riferimento al pannello delle celle e la coordinata della colonna.
     *
     * @param cp  Il riferimento al pannello delle celle.
     * @param col La coordinata della colonna.
     */
    public CellaRossa(CellePane cp, int col) {
        super(cp, Color.RED, col);
    }

    /**
     * Imposta il contenuto della cella rossa.
     * Il contenuto è determinato dal valore della colonna ottenuto dal pannello delle celle.
     */
    @Override
    public void impostaContenuto() {
        setContenuto(getCp().getValoreColonna(getCoordinata()));
        aggiungiContenuto();
    }
}
