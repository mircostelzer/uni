package View;

import Controller.MainGUI;
import Model.Tessera;
import javafx.scene.layout.GridPane;
import org.example.soluzione_2019_01_18.MainFX;

/**
 * Rappresenta il pannello della griglia di gioco nella GUI principale del gioco.
 */
public class GrigliaPane extends GridPane {

    /**
     * Costruttore del pannello della griglia di gioco.
     *
     * @param mg MainGUI a cui il pannello appartiene.
     */
    public GrigliaPane(MainGUI mg) {
        super();
        Tessera[][] tessere = mg.getGriglia().getGriglia();

        creaGriglia(tessere);
    }

    /**
     * Crea la griglia di gioco sulla GUI.
     *
     * @param grid Griglia di tessere del gioco.
     */
    public void creaGriglia(Tessera[][] grid){
        super.getChildren().clear();
        for (int i = 0; i < MainFX.getLATO(); i++) {
            for (int j = 0; j < MainFX.getLATO(); j++) {
                super.add(grid[i][j], j, i);
            }
        }
    }
}
