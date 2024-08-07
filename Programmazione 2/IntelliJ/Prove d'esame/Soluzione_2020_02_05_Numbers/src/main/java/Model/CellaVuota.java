package Model;

import javafx.scene.paint.Color;

/**
 * Classe che rappresenta una cella vuota in una griglia o una plancia di gioco.
 * Estende la classe Cella e utilizza un colore trasparente per indicare che è vuota.
 */
public class CellaVuota extends Cella {

    /**
     * Costruttore della classe CellaVuota.
     * Inizializza la cella vuota con un colore trasparente e rimuove eventuali figli (nodi) aggiuntivi.
     */
    public CellaVuota() {
        super(Color.TRANSPARENT);
        getChildren().removeLast();
    }

    /**
     * Metodo vuoto per impostare il contenuto.
     * Essendo una cella vuota, non viene impostato alcun contenuto.
     */
    @Override
    public void impostaContenuto() {
        // Nessuna implementazione necessaria per una cella vuota
    }
}
