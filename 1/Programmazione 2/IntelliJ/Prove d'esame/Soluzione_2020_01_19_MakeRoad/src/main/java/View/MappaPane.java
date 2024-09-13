package View;

import Controller.MainGUI;
import Model.Cella;
import Model.Celle.Prato;
import Model.Utils.Coordinate;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 * La classe MappaPane estende GridPane e rappresenta una mappa di celle.
 * Fornisce metodi per creare la mappa, sostituire elementi e ottenere elementi specifici.
 */
public class MappaPane extends GridPane {

    /**
     * Costruisce una nuova istanza di MappaPane e crea la mappa iniziale.
     *
     * @param mg L'oggetto MainGUI associato.
     */
    public MappaPane(MainGUI mg) {
        super();
        creaMappa(mg);
    }

    /**
     * Crea una mappa 10x10 inizializzata con celle di tipo Prato.
     *
     * @param mg L'oggetto MainGUI associato.
     */
    public void creaMappa(MainGUI mg) {
        super.getChildren().clear();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                super.add(new Prato(mg, new Coordinate(j, i)), j, i);
            }
        }
    }

    /**
     * Sostituisce un elemento nella mappa con un nuovo elemento alla posizione specificata.
     *
     * @param nuovoElemento Il nuovo elemento da aggiungere.
     * @param x La coordinata x della posizione.
     * @param y La coordinata y della posizione.
     */
    public void replaceElement(Cella nuovoElemento, int x, int y) {
        for (Node node : super.getChildren()) {
            if (GridPane.getColumnIndex(node) == y && GridPane.getRowIndex(node) == x) {
                super.getChildren().remove(node);
                break;
            }
        }
        super.add(nuovoElemento, y, x);
    }

    /**
     * Restituisce l'elemento alla posizione specificata nella mappa.
     *
     * @param x La coordinata x della posizione.
     * @param y La coordinata y della posizione.
     * @return Il nodo alla posizione specificata, o null se non esiste alcun nodo.
     */
    public Node getElementAt(int x, int y) {
        for (Node node : super.getChildren()) {
            Integer rowIndex = GridPane.getRowIndex(node);
            Integer colIndex = GridPane.getColumnIndex(node);
            if (rowIndex != null && colIndex != null && rowIndex == y && colIndex == x) {
                return node;
            }
        }
        return null;
    }
}
