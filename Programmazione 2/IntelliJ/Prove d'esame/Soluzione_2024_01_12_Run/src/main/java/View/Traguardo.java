package View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * La classe Traguardo rappresenta un traguardo come un rettangolo verticale.
 * Estende la classe Rectangle di JavaFX.
 */
public class Traguardo extends Rectangle {
    /**
     * Costruttore della classe Traguardo.
     * Inizializza il rettangolo con una larghezza di 10 pixel e un'altezza di 200 pixel,
     * impostando il colore di riempimento a blu chiaro.
     */
    public Traguardo() {
        super(10, 200);
        setFill(Color.LIGHTBLUE);
    }
}
