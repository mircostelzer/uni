package Model.Ostacoli;

import Model.Ostacolo;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * La classe OstacoloBlock rappresenta un ostacolo di tipo blocco.
 * Estende la classe astratta Ostacolo e definisce una forma specifica per il blocco.
 */
public class OstacoloBlock extends Ostacolo {
    /**
     * Costruttore di default per la classe OstacoloBlock.
     * Inizializza la forma del blocco come un rettangolo di 20x20 pixel con colore rosso.
     */
    public OstacoloBlock() {
        super();
        shape = new Rectangle(20, 20);
        shape.setFill(Color.RED);
    }
}
