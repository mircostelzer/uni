package Controller;

import Model.Abbonamenti;
import Model.AlertDisplayer;
import Model.Ventilatore;
import Model.VentilatoriDB;
import View.BottoniSorting;
import View.BottoniSpesa;
import View.StatsPane;
import View.VentilatoriPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Classe principale che gestisce l'interfaccia grafica di Geralt.
 */
public class MainGUI extends VBox {
    private BottoniSorting bottoniSorting;
    private StatsPane statsPane;
    private VentilatoriPane ventilatoriPane;
    private BottoniSpesa bottoniSpesa;

    private VentilatoriDB ventilatoriDB;
    private Abbonamenti abbonamenti;

    /**
     * Costruttore per creare l'interfaccia principale.
     *
     * @throws Exception Se si verifica un errore durante la creazione del database dei ventilatori.
     */
    public MainGUI() throws Exception {
        super();
        abbonamenti = new Abbonamenti(5);
        ventilatoriDB = new VentilatoriDB(this);
        bottoniSorting = new BottoniSorting(this);
        statsPane = new StatsPane();
        ventilatoriPane = new VentilatoriPane(ventilatoriDB);
        bottoniSpesa = new BottoniSpesa(this);

        GridPane gp = new GridPane();
        gp.add(bottoniSpesa, 0, 0);
        gp.add(ventilatoriPane, 1, 0);
        gp.add(bottoniSorting, 2, 0);
        gp.setHgap(10);

        super.getChildren().addAll(statsPane, gp);
    }

    /**
     * Restituisce il pannello dei ventilatori.
     *
     * @return Il pannello dei ventilatori.
     */
    public VentilatoriPane getVentilatoriPane() {
        return ventilatoriPane;
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
     * Restituisce il database dei ventilatori.
     *
     * @return Il database dei ventilatori.
     */
    public VentilatoriDB getVentilatoriDB() {
        return ventilatoriDB;
    }

    /**
     * Restituisce la lista degli abbonamenti.
     *
     * @return La lista degli abbonamenti.
     */
    public Abbonamenti getAbbonamenti() {
        return abbonamenti;
    }

    /**
     * Aggiorna lo stato dei ventilatori non abbonati in base al capitale disponibile.
     */
    public void aggiornaCostosi() {
        ArrayList<Ventilatore> nonAbbonati = ventilatoriDB.getNonAbbonati();
        for (Ventilatore v : nonAbbonati) {
            if (statsPane.getCapitale() < (statsPane.getSpesaMensile() + v.getCosto())) {
                v.impostaStroke(Color.RED);
            } else {
                v.impostaStroke(Color.BLACK);
            }
        }
    }

    /**
     * Aggiorna lo stato dei ventilatori abbonati.
     */
    public void aggiornaAbbonati() {
        for (Ventilatore v : abbonamenti) {
            v.impostaStroke(Color.BLACK);
        }
    }

    /**
     * Passa al mese successivo, aggiornando il capitale e la lista dei ventilatori.
     */
    public void meseSuccessivo() {
        if (statsPane.getSpesaMensile() > statsPane.getCapitale()) {
            AlertDisplayer.display_ERROR_Alert();
            abbonamenti.rimuoviPiuCostoso();
            aggiornaCostosi();
            aggiornaAbbonati();
        } else {
            statsPane.incrementaMesiTrascorsi();
            statsPane.aggiornaCapitale(-statsPane.getSpesaMensile());
            ventilatoriDB.resetVentilatori();
            abbonamenti.clear();
            ventilatoriPane.creaPane(ventilatoriDB);
            aggiornaCostosi();
        }
    }
}
