package Model;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Classe astratta che rappresenta una cella in una griglia o una plancia di gioco.
 * Ogni cella ha un colore di sfondo e può visualizzare un contenuto numerico.
 */
public abstract class Cella extends StackPane {
    private int contenuto;

    /**
     * Costruttore della classe Cella.
     * Inizializza la cella con un colore di sfondo specificato.
     *
     * @param colore Il colore di sfondo della cella.
     */
    public Cella(Color colore) {
        super();
        Rectangle r = new Rectangle(50, 50);
        r.setFill(colore);
        r.setStroke(Color.TRANSPARENT);
        super.getChildren().addAll(r);
    }

    /**
     * Aggiunge il contenuto alla cella.
     * Se c'è già un nodo Text, viene rimosso prima di aggiungere il nuovo contenuto.
     */
    public void aggiungiContenuto() {
        if (super.getChildren().getLast() instanceof Text) {
            super.getChildren().removeLast();
        }
        Text t = new Text(String.valueOf(contenuto));
        t.setFill(Color.YELLOW);
        super.getChildren().add(t);
    }

    /**
     * Ottiene il contenuto della cella.
     *
     * @return Il contenuto della cella come un intero.
     */
    public int getContenuto() {
        return contenuto;
    }

    /**
     * Metodo astratto per impostare il contenuto della cella.
     * Le sottoclassi devono implementare questo metodo.
     */
    public abstract void impostaContenuto();

    /**
     * Imposta il contenuto della cella.
     *
     * @param contenuto Il nuovo contenuto della cella.
     */
    public void setContenuto(int contenuto) {
        this.contenuto = contenuto;
    }
}
