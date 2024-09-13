package View;

import Model.Carta;
import Model.Mano;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 * La classe HandPane rappresenta il pannello che visualizza la mano di un giocatore.
 */
public class HandPane extends HBox {

    /**
     * Costruttore per la classe HandPane.
     *
     * @param giocatoreCorrente La mano del giocatore corrente
     */
    public HandPane(Mano giocatoreCorrente) {
        super();

        creaMano(giocatoreCorrente.getCarte());
    }

    /**
     * Crea la rappresentazione grafica della mano del giocatore.
     *
     * @param mano La mano del giocatore
     */
    public void creaMano(ArrayList<Carta> mano) {
        getChildren().clear();
        for (Carta c : mano) {
            getChildren().add(creaStackPane(c));
        }
    }

    /**
     * Crea un oggetto StackPane per rappresentare una carta.
     *
     * @param c La carta da rappresentare
     * @return Lo StackPane che rappresenta la carta
     */
    private StackPane creaStackPane(Carta c) {
        Rectangle r = new Rectangle(40, 40);
        r.setFill(Color.CYAN);
        r.setStroke(Color.BLACK);
        Text t = new Text(c.toString());
        return new StackPane(r, t);
    }
}
