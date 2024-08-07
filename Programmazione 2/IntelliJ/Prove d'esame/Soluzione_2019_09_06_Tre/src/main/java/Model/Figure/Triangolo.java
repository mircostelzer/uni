package Model.Figure;

import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 * La classe Triangolo estende la classe Polygon di JavaFX.
 * Questa classe rappresenta un triangolo equilatero che viene inizializzato con una lunghezza del lato specificata,
 * e con colori predefiniti per il riempimento e il contorno.
 */
public class Triangolo extends Polygon {

    /**
     * Costruisce un nuovo Triangolo con la lunghezza del lato specificata.
     * Il triangolo sarà equilatero e avrà il riempimento di colore giallo e il contorno di colore rosso.
     *
     * @param sideLength La lunghezza del lato del triangolo.
     */
    public Triangolo(double sideLength) {
        super();
        double height = sideLength * Math.sqrt(3) / 2;
        double[] points = {
                0, height,
                sideLength / 2, 0,
                sideLength, height
        };

        ObservableList<Double> trianglePoints = super.getPoints();
        for (double point : points) {
            trianglePoints.add(point);
        }

        super.setFill(Color.YELLOW);
        super.setStroke(Color.RED);
    }
}
