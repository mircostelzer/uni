package Controller;

import Model.CoordinateHelper;
import Model.Stats;
import View.Omino;
import View.Traguardo;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

/**
 * La classe MainGUI estende Pane e gestisce gli elementi principali dell'interfaccia grafica,
 * inclusi l'omino, il traguardo, gli ostacoli e le statistiche del gioco.
 */
public class MainGUI extends Pane {
    private Omino omino;
    private Traguardo traguardo;
    private ArrayList<Shape> ostacoli;
    private Stats stats;
    private CoordinateHelper coordinateHelper;
    private static boolean ALIVE;

    /**
     * Costruttore della classe MainGUI.
     * Inizializza gli elementi dell'interfaccia grafica e li posiziona nel pannello.
     */
    public MainGUI() {
        super();
        ALIVE = true;
        ostacoli = new ArrayList<>(6);
        omino = new Omino();
        stats = new Stats();
        traguardo = new Traguardo();

        coordinateHelper = new CoordinateHelper(this, omino, stats);

        omino.setLayoutX(10.0);
        omino.setLayoutY(100.0);
        traguardo.setLayoutX(490);
        stats.setLayoutX(200);
        stats.setLayoutY(20);

        getChildren().addAll(omino, traguardo, stats);
        coordinateHelper.spawnOstacoli();
    }

    /**
     * Restituisce lo stato di vita dell'omino.
     *
     * @return true se l'omino è vivo, false altrimenti
     */
    public static boolean isALIVE() {
        return ALIVE;
    }

    /**
     * Imposta lo stato di vita dell'omino a false.
     */
    public static void setALIVE() {
        ALIVE = false;
    }

    /**
     * Restituisce l'oggetto Omino.
     *
     * @return l'oggetto Omino
     */
    public Omino getOmino() {
        return omino;
    }

    /**
     * Restituisce la lista degli ostacoli.
     *
     * @return una lista di oggetti Shape rappresentanti gli ostacoli
     */
    public ArrayList<Shape> getOstacoli() {
        return ostacoli;
    }

    /**
     * Restituisce l'oggetto Stats.
     *
     * @return l'oggetto Stats
     */
    public Stats getStats() {
        return stats;
    }

    /**
     * Restituisce l'oggetto CoordinateHelper.
     *
     * @return l'oggetto CoordinateHelper
     */
    public CoordinateHelper getCoordinateHelper() {
        return coordinateHelper;
    }

    /**
     * Sposta tutti gli ostacoli e il traguardo verso sinistra di 10 unità.
     */
    public void shiftAllLeft() {
        traguardo.setLayoutX(traguardo.getLayoutX() - 10);

        for (Shape s : ostacoli) {
            s.setLayoutX(s.getLayoutX() - 10);
        }
    }

    /**
     * Restituisce l'oggetto Traguardo.
     *
     * @return l'oggetto Traguardo
     */
    public Traguardo getTraguardo() {
        return traguardo;
    }
}
