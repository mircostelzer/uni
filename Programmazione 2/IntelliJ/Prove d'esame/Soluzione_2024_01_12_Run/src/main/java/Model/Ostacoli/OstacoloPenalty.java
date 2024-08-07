package Model.Ostacoli;

import Model.Ostacolo;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * La classe OstacoloPenalty rappresenta un ostacolo di tipo penalità.
 * Estende la classe astratta Ostacolo e definisce una forma specifica per la penalità.
 */
public class OstacoloPenalty extends Ostacolo {
    /**
     * Costruttore di default per la classe OstacoloPenalty.
     * Inizializza la forma della penalità come un cerchio con raggio di 10 pixel e colore blu.
     */
    public OstacoloPenalty() {
        super();
        shape = new Circle(10);
        shape.setFill(Color.BLUE);
    }
}
