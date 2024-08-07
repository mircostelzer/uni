package Model.CelleCentrali;

import Model.CellaCentrale;
import javafx.scene.paint.Color;

/**
 * Classe che rappresenta una cella centrale di colore grigio in una griglia o una plancia di gioco.
 * Estende la classe CellaCentrale e implementa la logica per aggiornare il valore della cella.
 */
public class CellaGrigia extends CellaCentrale {

    /**
     * Costruttore della classe CellaGrigia.
     * Inizializza la cella grigia con il colore grigio.
     */
    public CellaGrigia() {
        super(Color.GRAY);
    }

    /**
     * Aggiorna il valore della cella grigia.
     * Se il valore corrente è maggiore di 3, viene reimpostato a 0. Altrimenti, il valore viene incrementato di 1.
     */
    @Override
    public void aggiornaValore() {
        if (getContenuto() + 1 > 3) {
            setContenuto(0);
        } else {
            setContenuto(getContenuto() + 1);
        }
        aggiungiContenuto();
    }
}
