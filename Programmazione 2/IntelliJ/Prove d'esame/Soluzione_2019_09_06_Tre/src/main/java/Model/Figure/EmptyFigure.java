package Model.Figure;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * La classe EmptyFigure estende la classe Rectangle di JavaFX.
 * Questa classe rappresenta una figura vuota che viene inizializzata come un quadrato
 * con lato specificato e con colori predefiniti per il riempimento e il contorno.
 */
public class EmptyFigure extends Rectangle {

    /**
     * Costruisce una nuova EmptyFigure con il lato specificato.
     * Il quadrato avrà il riempimento di colore grigio chiaro e il contorno di colore acquamarina.
     *
     * @param lato La lunghezza del lato del quadrato.
     */
    public EmptyFigure(double lato) {
        super(lato, lato);
        super.setFill(Color.LIGHTGRAY);
        super.setStroke(Color.AQUAMARINE);
    }
}
