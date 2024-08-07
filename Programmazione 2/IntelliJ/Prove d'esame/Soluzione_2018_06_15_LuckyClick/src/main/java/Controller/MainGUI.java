package Controller;

import View.CellePane;
import View.StatsPane;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 * La classe MainGUI rappresenta l'interfaccia grafica principale del gioco.
 * Gestisce la disposizione degli elementi grafici come il pannello di statistiche e il pannello delle celle.
 */
public class MainGUI extends VBox {
    private StatsPane statsPane; // Pannello delle statistiche
    private CellePane cellePane; // Pannello delle celle di gioco

    /**
     * Costruttore per la classe MainGUI.
     * Inizializza il pannello delle statistiche e il pannello delle celle di gioco.
     */
    public MainGUI() {
        super();

        statsPane = new StatsPane();
        cellePane = new CellePane(this);

        statsPane.setAlignment(Pos.CENTER);

        super.getChildren().addAll(statsPane, cellePane);
    }

    /**
     * Restituisce il pannello delle statistiche.
     *
     * @return Il pannello delle statistiche
     */
    public StatsPane getStatsPane() {
        return statsPane;
    }

    /**
     * Restituisce il pannello delle celle di gioco.
     *
     * @return Il pannello delle celle di gioco
     */
    public CellePane getCellePane() {
        return cellePane;
    }
}
