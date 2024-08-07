package Model.CelleCentrali;

import Model.CellaCentrale;
import javafx.scene.paint.Color;

/**
 * Classe che rappresenta una cella centrale di colore blu in una griglia o una plancia di gioco.
 * Estende la classe CellaCentrale e implementa la logica per aggiornare il valore della cella.
 */
public class CellaBlu extends CellaCentrale {

    /**
     * Costruttore della classe CellaBlu.
     * Inizializza la cella blu con il colore blu.
     */
    public CellaBlu() {
        super(Color.BLUE);
    }

    /**
     * Aggiorna il valore della cella blu.
     * Se il valore corrente è inferiore a 0, viene reimpostato a 3. Altrimenti, il valore viene decrementato di 1.
     */
    @Override
    public void aggiornaValore() {
        if (getContenuto() - 1 < 0) {
            setContenuto(3);
        } else {
            setContenuto(getContenuto() - 1);
        }
        aggiungiContenuto();
    }
}
