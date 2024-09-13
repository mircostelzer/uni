package Model;

import javafx.scene.paint.Color;
import java.util.Random;

/**
 * Classe astratta che rappresenta una cella centrale in una griglia o una plancia di gioco.
 * Estende la classe Cella e inizializza il contenuto in modo casuale.
 */
public abstract class CellaCentrale extends Cella {

    /**
     * Costruttore della classe CellaCentrale.
     * Inizializza la cella centrale con un colore specificato e imposta il contenuto.
     *
     * @param colore Il colore di sfondo della cella centrale.
     */
    public CellaCentrale(Color colore) {
        super(colore);
        impostaContenuto();
    }

    /**
     * Imposta il contenuto della cella centrale in modo casuale.
     * Il contenuto sarà un numero intero compreso tra 0 e 3.
     */
    @Override
    public void impostaContenuto() {
        Random r = new Random();
        setContenuto(r.nextInt(4));
        aggiungiContenuto();
    }

    /**
     * Metodo astratto per aggiornare il valore della cella centrale.
     * Le sottoclassi devono implementare questo metodo.
     */
    public abstract void aggiornaValore();
}
