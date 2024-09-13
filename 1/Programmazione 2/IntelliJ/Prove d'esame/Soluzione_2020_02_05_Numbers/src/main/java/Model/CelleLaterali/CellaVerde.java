package Model.CelleLaterali;

import Model.CellaLaterale;
import View.CellePane;
import javafx.scene.paint.Color;

/**
 * Classe che rappresenta una cella laterale di colore verde in una griglia o una plancia di gioco.
 * Estende la classe CellaLaterale e imposta il contenuto basato sul valore della riga.
 */
public class CellaVerde extends CellaLaterale {

    /**
     * Costruttore della classe CellaVerde.
     * Inizializza la cella verde con un riferimento al pannello delle celle e la coordinata della riga.
     *
     * @param cp  Il riferimento al pannello delle celle.
     * @param row La coordinata della riga.
     */
    public CellaVerde(CellePane cp, int row) {
        super(cp, Color.GREEN, row);
    }

    /**
     * Imposta il contenuto della cella verde.
     * Il contenuto è determinato dal valore della riga ottenuto dal pannello delle celle.
     */
    @Override
    public void impostaContenuto() {
        setContenuto(getCp().getValoreRiga(getCoordinata()));
        aggiungiContenuto();
    }
}
