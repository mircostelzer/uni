package Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Classe astratta che rappresenta una pallina.
 */
public abstract class Pallina extends Circle {

    /**
     * Costruttore della classe Pallina.
     * Inizializza una pallina con un determinato colore e un raggio fisso di 20.
     *
     * @param colore Colore della pallina.
     */
    public Pallina(Color colore) {
        super(20);
        super.setFill(colore);
    }
}

