package Model;

import Controller.MainGUI;
import Model.Utils.Coordinate;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * La classe astratta Cella estende StackPane di JavaFX e rappresenta una cella generica in una griglia.
 * Ogni cella ha una coordinata, un colore e può eseguire un'azione specifica.
 */
public abstract class Cella extends StackPane {
    private MainGUI mg;
    private Coordinate coordinate;

    /**
     * Costruisce una nuova istanza di Cella.
     *
     * @param mg L'oggetto MainGUI associato.
     * @param coordinate La coordinata della cella nella griglia.
     * @param colore Il colore di riempimento della cella.
     */
    public Cella(MainGUI mg, Coordinate coordinate, Color colore) {
        super();
        this.mg = mg;
        this.coordinate = coordinate;
        Rectangle rectangle = new Rectangle(45, 45);
        rectangle.setFill(colore);
        rectangle.setStroke(Color.GRAY);
        super.getChildren().addAll(rectangle);
        setCellaAction();
    }

    /**
     * Restituisce l'oggetto MainGUI associato a questa cella.
     *
     * @return L'oggetto MainGUI associato.
     */
    public MainGUI getMg() {
        return mg;
    }

    /**
     * Restituisce la coordinata della cella nella griglia.
     *
     * @return La coordinata della cella.
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Metodo astratto per impostare l'azione specifica della cella.
     * Deve essere implementato dalle classi concrete.
     */
    public abstract void setCellaAction();
}
