package Controller;

import Model.Griglia;
import Model.Tessera;
import View.ButtonPane;
import View.GrigliaPane;
import View.StatsPane;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import org.example.soluzione_2019_01_18.MainFX;

/**
 * Rappresenta la GUI principale del gioco.
 */
public class MainGUI extends VBox {
    private StatsPane statsPane;
    private GrigliaPane grigliaPane;
    private Griglia griglia;
    private ButtonPane buttonPane;

    /**
     * Costruttore della GUI principale.
     */
    public MainGUI() {
        super();

        griglia = new Griglia(this);
        statsPane = new StatsPane(this);
        grigliaPane = new GrigliaPane(this);
        buttonPane = new ButtonPane(this);

        super.getChildren().addAll(statsPane, grigliaPane, buttonPane);
        buttonPane.setPadding(new Insets(0,0,0, 15*MainFX.getLATO()));
        statsPane.setPadding(new Insets(0,0,0, 10*MainFX.getLATO()));
    }

    /**
     * Restituisce la griglia di gioco.
     *
     * @return La griglia di gioco.
     */
    public Griglia getGriglia() {
        return griglia;
    }

    /**
     * Restituisce il pannello della griglia di gioco.
     *
     * @return Il pannello della griglia di gioco.
     */
    public GrigliaPane getGrigliaPane() {
        return grigliaPane;
    }

    /**
     * Restituisce il pannello delle statistiche.
     *
     * @return Il pannello delle statistiche.
     */
    public StatsPane getStatsPane() {
        return statsPane;
    }

    /**
     * Resetta la griglia di gioco e aggiorna le statistiche.
     */
    public void resetAll(){
        Tessera[][] grid = griglia.creaGriglia(this);
        griglia.setGriglia(grid);
        grigliaPane.creaGriglia(grid);
        statsPane.aggiornaPunteggioText(0);
    }
}
