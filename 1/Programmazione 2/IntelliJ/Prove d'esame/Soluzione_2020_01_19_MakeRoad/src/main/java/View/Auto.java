package View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * La classe astratta Auto estende Rectangle di JavaFX e rappresenta un'auto.
 * Le dimensioni dell'auto sono specificate dai parametri x e y.
 */
public abstract class Auto extends Rectangle {

    /**
     * Costruisce una nuova istanza di Auto con le dimensioni specificate.
     *
     * @param x La larghezza dell'auto.
     * @param y L'altezza dell'auto.
     */
    public Auto(double x, double y) {
        super(x, y);
        setFill(Color.WHITE);
    }
}
