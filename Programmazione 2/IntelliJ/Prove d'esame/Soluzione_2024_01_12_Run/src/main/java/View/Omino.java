package View;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

/**
 * La classe Omino rappresenta una figura composta da un cerchio per la testa e un poligono per il corpo.
 * Estende la classe Group di JavaFX.
 */
public class Omino extends Group {
    private Polygon corpo;
    private Circle testa;

    /**
     * Costruttore della classe Omino.
     * Inizializza la testa come un cerchio di colore nero e il corpo come un poligono di colore verde.
     * Aggiunge la testa e il corpo come figli del gruppo.
     */
    public Omino() {
        super();
        testa = new Circle(5);
        testa.setFill(Color.BLACK);

        corpo = new Polygon();
        corpo.getPoints().addAll(
                0.0, 0.0,
                -5.0, 30.0,
                5.0, 30.0
        );
        corpo.setFill(Color.GREEN);
        getChildren().addAll(corpo, testa);
    }

    /**
     * Restituisce la testa dell'omino.
     *
     * @return un oggetto Circle che rappresenta la testa dell'omino
     */
    public Circle getTesta() {
        return testa;
    }
}
