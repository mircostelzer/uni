package Controller;

import View.Bottoni.BottoniPerGestire;
import View.ScacchieraPane;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 * La classe MainGUI estende VBox di JavaFX e rappresenta l'interfaccia principale dell'applicazione.
 * Contiene una ScacchieraPane e i BottoniPerGestire associati.
 */
public class MainGUI extends VBox {
    private ScacchieraPane scacchieraPane;
    private BottoniPerGestire bottoniPerGestire;

    /**
     * Costruisce una nuova istanza di MainGUI.
     * Inizializza e aggiunge la ScacchieraPane e i BottoniPerGestire al layout.
     */
    public MainGUI() {
        super();
        scacchieraPane = new ScacchieraPane();
        bottoniPerGestire = new BottoniPerGestire(scacchieraPane);

        super.getChildren().addAll(scacchieraPane, bottoniPerGestire);
        bottoniPerGestire.setAlignment(Pos.CENTER);
        scacchieraPane.setAlignment(Pos.CENTER);
    }

    /**
     * Restituisce i BottoniPerGestire associati a questa MainGUI.
     *
     * @return I BottoniPerGestire associati.
     */
    public BottoniPerGestire getBottoniPerGestire() {
        return bottoniPerGestire;
    }

    /**
     * Restituisce la ScacchieraPane associata a questa MainGUI.
     *
     * @return La ScacchieraPane associata.
     */
    public ScacchieraPane getScacchieraPane() {
        return scacchieraPane;
    }
}
