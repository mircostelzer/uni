package Controller;

import Model.geralt.Geralt;
import View.ButtonPane;
import View.MutationsPane;
import View.SpellsPane;
import View.StatsPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Classe principale che gestisce l'interfaccia grafica di Geralt.
 */
public class MainGUI extends AnchorPane {
    private StatsPane statsPane;
    private SpellsPane spellsPane;
    private MutationsPane mutationsPane;
    private ButtonPane buttonPane;
    private Geralt geralt;

    /**
     * Costruttore per creare l'interfaccia principale.
     */
    public MainGUI() {
        super();
        geralt = new Geralt();
        statsPane = new StatsPane(geralt);
        spellsPane = new SpellsPane(geralt);
        mutationsPane = new MutationsPane(geralt);
        buttonPane = new ButtonPane(this);

        VBox bottomPane = new VBox(new Text("Mutazioni Possibili"), buttonPane);

        super.getChildren().addAll(statsPane, spellsPane, mutationsPane, bottomPane);

        AnchorPane.setTopAnchor(statsPane, 20.0);
        AnchorPane.setLeftAnchor(statsPane, 10.0);

        AnchorPane.setTopAnchor(mutationsPane, 10.0);
        AnchorPane.setRightAnchor(mutationsPane, 10.0);

        AnchorPane.setLeftAnchor(spellsPane, 10.0);
        AnchorPane.setTopAnchor(spellsPane, 100.0);

        AnchorPane.setBottomAnchor(bottomPane, 10.0);
        AnchorPane.setLeftAnchor(bottomPane, 10.0);
    }

    /**
     * Restituisce il personaggio Geralt.
     *
     * @return Il personaggio Geralt.
     */
    public Geralt getGeralt() {
        return geralt;
    }

    /**
     * Restituisce il pannello delle mutazioni.
     *
     * @return Il pannello delle mutazioni.
     */
    public MutationsPane getMutationsPane() {
        return mutationsPane;
    }

    /**
     * Restituisce il pannello degli incantesimi.
     *
     * @return Il pannello degli incantesimi.
     */
    public SpellsPane getSpellsPane() {
        return spellsPane;
    }

    /**
     * Restituisce il pannello delle statistiche.
     *
     * @return Il pannello delle statistiche.
     */
    public StatsPane getStatsPane() {
        return statsPane;
    }
}
