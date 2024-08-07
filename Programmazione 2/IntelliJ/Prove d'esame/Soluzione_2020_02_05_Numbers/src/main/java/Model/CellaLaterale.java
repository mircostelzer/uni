package Model;

import View.CellePane;
import javafx.scene.paint.Color;

/**
 * Classe astratta che rappresenta una cella laterale in una griglia o una plancia di gioco.
 * Estende la classe Cella e aggiunge una coordinata e un riferimento al pannello delle celle.
 */
public abstract class CellaLaterale extends Cella {
    private int coordinata;
    private CellePane cp;

    /**
     * Costruttore della classe CellaLaterale.
     * Inizializza la cella laterale con un colore specificato, un riferimento al pannello delle celle e una coordinata.
     *
     * @param cp         Il riferimento al pannello delle celle.
     * @param colore     Il colore di sfondo della cella laterale.
     * @param coordinata La coordinata della cella laterale.
     */
    public CellaLaterale(CellePane cp, Color colore, int coordinata) {
        super(colore);
        this.cp = cp;
        this.coordinata = coordinata;
    }

    /**
     * Ottiene il riferimento al pannello delle celle.
     *
     * @return Il riferimento al pannello delle celle.
     */
    public CellePane getCp() {
        return cp;
    }

    /**
     * Ottiene la coordinata della cella laterale.
     *
     * @return La coordinata della cella laterale.
     */
    public int getCoordinata() {
        return coordinata;
    }
}
