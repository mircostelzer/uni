package View.Bottoni;

import Model.Figure.Cerchio;
import Model.Coordinate;
import Model.Figure.EmptyFigure;
import Model.Figure.Triangolo;
import View.Casella;
import View.ScacchieraPane;
import com.soluzione_2019_09_06.MainFX;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * La classe BottoniPerGestire estende HBox di JavaFX e fornisce bottoni per gestire e controllare una ScacchieraPane.
 */
public class BottoniPerGestire extends HBox {
    private Button clearAll;
    private Button check;

    /**
     * Costruisce una nuova istanza di BottoniPerGestire associata ad una specifica ScacchieraPane.
     * Inizializza i bottoni e imposta le loro azioni.
     *
     * @param scacchieraPane La ScacchieraPane associata ai bottoni.
     */
    public BottoniPerGestire(ScacchieraPane scacchieraPane) {
        super();
        clearAll = new Button("clear All");
        check = new Button("Check");

        setClearAllAction(scacchieraPane);
        setCheckAction(scacchieraPane);

        super.getChildren().addAll(clearAll, check);
        super.setSpacing(25);
    }

    /**
     * Cancella tutte le forme nella ScacchieraPane impostandole a EmptyFigure.
     *
     * @param sp La ScacchieraPane da pulire.
     */
    public void clearAllAction(ScacchieraPane sp) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ((Casella) sp.getElementAt(i, j)).setForma(new EmptyFigure(MainFX.getLATO_EMPTY_FIGURE()));
            }
        }
    }

    /**
     * Controlla se ci sono tre forme uguali in una riga o colonna nella ScacchieraPane e mostra un avviso se ne trova.
     *
     * @param sp La ScacchieraPane da controllare.
     */
    public void checkAction(ScacchieraPane sp) {
        int countTriangolo;
        int countCerchio;

        // Controllo colonne
        for (int i = 0; i < 3; i++) {
            countTriangolo = 0;
            countCerchio = 0;
            for (int j = 0; j < 3; j++) {
                Casella cell = (Casella) sp.getElementAt(i, j);
                if (cell.getForma() instanceof Triangolo) {
                    countTriangolo++;
                } else if (cell.getForma() instanceof Cerchio) {
                    countCerchio++;
                }
            }
            if (countTriangolo == 3 || countCerchio == 3) {
                displayAlert(new Coordinate(false, i + 1));
                return;
            }
        }

        // Controllo righe
        for (int i = 0; i < 3; i++) {
            countTriangolo = 0;
            countCerchio = 0;
            for (int j = 0; j < 3; j++) {
                Casella cell = (Casella) sp.getElementAt(j, i);
                if (cell.getForma() instanceof Triangolo) {
                    countTriangolo++;
                } else if (cell.getForma() instanceof Cerchio) {
                    countCerchio++;
                }
            }
            if (countTriangolo == 3 || countCerchio == 3) {
                displayAlert(new Coordinate(true, i + 1));
                return;
            }
        }
    }

    /**
     * Imposta l'azione del bottone clearAll per pulire tutte le forme nella ScacchieraPane.
     *
     * @param sp La ScacchieraPane su cui agire.
     */
    private void setClearAllAction(ScacchieraPane sp) {
        clearAll.setOnAction(event -> clearAllAction(sp));
    }

    /**
     * Imposta l'azione del bottone check per controllare le forme nella ScacchieraPane.
     *
     * @param sp La ScacchieraPane su cui agire.
     */
    private void setCheckAction(ScacchieraPane sp) {
        check.setOnAction(event -> checkAction(sp));
    }

    /**
     * Mostra un avviso informativo se ci sono tre forme uguali in una riga o colonna.
     *
     * @param c La coordinata della riga o colonna con tre forme uguali.
     */
    private void displayAlert(Coordinate c) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("CHECK");
        a.setContentText("Tre uguali in " + ((c.isRiga()) ? "riga " : "colonna ") + c.getCoordinata());
        a.setHeaderText("TRE!");
        a.showAndWait();
    }
}
