package Model.Figure;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * La classe Cerchio estende la classe Circle di JavaFX.
 * Questa classe rappresenta un cerchio che viene inizializzato con un raggio specifico,
 * e con colori predefiniti per il riempimento e il contorno.
 */
public class Cerchio extends Circle {

    /**
     * Costruisce un nuovo Cerchio con il raggio specificato.
     * Il cerchio avrà il riempimento di colore giallo e il contorno di colore rosso.
     *
     * @param raggio Il raggio del cerchio.
     */
    public Cerchio(double raggio) {
        super(raggio);
        setFill(Color.YELLOW);
        setStroke(Color.RED);
    }
}
