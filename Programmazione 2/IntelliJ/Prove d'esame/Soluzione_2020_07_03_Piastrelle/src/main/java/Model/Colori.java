package Model;

import javafx.scene.paint.Color;
import java.util.ArrayList;

/**
 * La classe Colori rappresenta una lista di colori disponibili per le piastrelle.
 * Estende la classe ArrayList di Java.
 */
public class Colori extends ArrayList<Color> {
    /**
     * Costruttore della classe Colori.
     * Inizializza la lista con sei colori predefiniti.
     */
    public Colori() {
        super(6);
        add(Color.BROWN);
        add(Color.WHEAT);
        add(Color.TEAL);
        add(Color.DARKBLUE);
        add(Color.OLIVE);
        add(Color.GOLD);
    }
}
