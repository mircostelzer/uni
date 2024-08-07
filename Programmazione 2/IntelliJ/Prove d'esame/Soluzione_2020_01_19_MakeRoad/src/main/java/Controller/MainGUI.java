package Controller;

import Model.Utils.Coordinate;
import View.Bottoni.BottoniCelle;
import View.Bottoni.BottoniGestione;
import View.MappaPane;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * La classe MainGUI estende AnchorPane e rappresenta l'interfaccia principale dell'applicazione.
 * Contiene una mappa, bottoni per la gestione delle celle e bottoni per la gestione delle auto.
 */
public class MainGUI extends AnchorPane {
    private MappaPane mappaPane;
    private BottoniCelle bottoniCelle;
    private BottoniGestione bottoniGestione;

    private static Coordinate coordinateAuto;

    /**
     * Costruisce una nuova istanza di MainGUI.
     * Inizializza la mappa, i bottoni per la gestione delle celle e i bottoni per la gestione delle auto.
     */
    public MainGUI() {
        super();
        super.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        mappaPane = new MappaPane(this);
        bottoniCelle = new BottoniCelle();
        bottoniGestione = new BottoniGestione(this);

        super.getChildren().addAll(mappaPane, bottoniCelle, bottoniGestione);

        AnchorPane.setTopAnchor(mappaPane, 0.0);
        AnchorPane.setLeftAnchor(mappaPane, 0.0);

        AnchorPane.setBottomAnchor(bottoniCelle, 0.0);
        AnchorPane.setLeftAnchor(bottoniCelle, 0.0);

        AnchorPane.setBottomAnchor(bottoniGestione, 0.0);
        AnchorPane.setRightAnchor(bottoniGestione, 20.0);
    }

    /**
     * Restituisce i bottoni per la gestione delle celle.
     *
     * @return I bottoni per la gestione delle celle.
     */
    public BottoniCelle getBottoniCelle() {
        return bottoniCelle;
    }

    /**
     * Restituisce la mappa dell'applicazione.
     *
     * @return La mappa dell'applicazione.
     */
    public MappaPane getMappaPane() {
        return mappaPane;
    }

    /**
     * Restituisce i bottoni per la gestione delle auto.
     *
     * @return I bottoni per la gestione delle auto.
     */
    public BottoniGestione getBottoniGestione() {
        return bottoniGestione;
    }

    /**
     * Restituisce la coordinata corrente dell'auto.
     *
     * @return La coordinata corrente dell'auto.
     */
    public static Coordinate getCoordinateAuto() {
        return coordinateAuto;
    }

    /**
     * Imposta la coordinata corrente dell'auto.
     *
     * @param coordinateAuto La nuova coordinata dell'auto.
     */
    public static void setCoordinateAuto(Coordinate coordinateAuto) {
        MainGUI.coordinateAuto = coordinateAuto;
    }
}
