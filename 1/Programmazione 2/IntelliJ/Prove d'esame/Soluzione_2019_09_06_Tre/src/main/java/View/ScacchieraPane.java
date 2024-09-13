package View;

import View.Caselle.CasellaDueBottoni;
import View.Caselle.CasellaTreBottoni;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.util.Random;

/**
 * La classe ScacchieraPane estende GridPane di JavaFX e rappresenta una scacchiera con celle che possono contenere due o tre bottoni.
 */
public class ScacchieraPane extends GridPane {

    /**
     * Costruisce una nuova ScacchieraPane, inizializzando la griglia e impostando gli spazi tra le celle.
     */
    public ScacchieraPane() {
        super();
        creaGriglia();
        super.setHgap(10);
        super.setVgap(10);
    }

    /**
     * Crea una griglia 3x3 di caselle, alternando tra CasellaDueBottoni e CasellaTreBottoni in modo casuale.
     */
    public void creaGriglia(){
        super.getChildren().clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Random r = new Random();
                Casella c;
                if(r.nextBoolean())
                    c = new CasellaDueBottoni();
                else
                    c = new CasellaTreBottoni();
                super.add(c, j, i);
            }
        }
    }

    /**
     * Restituisce l'elemento nella posizione specificata della griglia.
     *
     * @param x La coordinata x (colonna) dell'elemento.
     * @param y La coordinata y (riga) dell'elemento.
     * @return Il nodo nella posizione specificata, o null se non esiste alcun nodo.
     */
    public Node getElementAt(int x, int y) {
        for (Node node : super.getChildren()) {
            Integer columnIndex = GridPane.getColumnIndex(node);
            Integer rowIndex = GridPane.getRowIndex(node);

            columnIndex = (columnIndex == null) ? 0 : columnIndex;
            rowIndex = (rowIndex == null) ? 0 : rowIndex;

            if (columnIndex == x && rowIndex == y) {
                return node;
            }
        }
        return null;
    }
}
