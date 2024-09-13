package View;

import Model.Figure.EmptyFigure;
import View.Bottoni.Bottoni;
import com.soluzione_2019_09_06.MainFX;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;

/**
 * La classe astratta Casella estende VBox di JavaFX e rappresenta una cella di una griglia con una figura e dei bottoni.
 * Questa classe gestisce una forma che può essere aggiornata e bottoni associati alla cella.
 */
public abstract class Casella extends VBox {
    private Shape forma;
    private HBox bottoni;
    private StackPane sp;

    /**
     * Costruisce una nuova Casella inizializzando la forma con un EmptyFigure e impostando i bottoni.
     * La forma può essere cambiata cliccando su di essa.
     */
    public Casella() {
        super();
        forma = new EmptyFigure(MainFX.getLATO_EMPTY_FIGURE());

        sp = new StackPane(forma);
        sp.setOnMouseClicked(event -> setForma(new EmptyFigure(MainFX.getLATO_EMPTY_FIGURE())));
        bottoni = aggiungiBottoni(new Bottoni(this));
        bottoni.setAlignment(Pos.CENTER);

        super.getChildren().addAll(sp, bottoni);
        super.setSpacing(10);
    }

    /**
     * Metodo astratto per aggiungere bottoni alla casella. Deve essere implementato dalle classi concrete.
     *
     * @param b Un oggetto Bottoni che rappresenta i bottoni da aggiungere alla casella.
     * @return Un HBox contenente i bottoni aggiunti.
     */
    public abstract HBox aggiungiBottoni(Bottoni b);

    /**
     * Imposta una nuova forma nella casella.
     * La forma precedente viene rimossa e sostituita con quella nuova.
     *
     * @param forma La nuova forma da impostare nella casella.
     */
    public void setForma(Shape forma) {
        this.forma = forma;
        sp.getChildren().clear();
        sp.getChildren().add(forma);
    }

    /**
     * Restituisce la forma attualmente presente nella casella.
     *
     * @return La forma attuale della casella.
     */
    public Shape getForma() {
        return forma;
    }
}
