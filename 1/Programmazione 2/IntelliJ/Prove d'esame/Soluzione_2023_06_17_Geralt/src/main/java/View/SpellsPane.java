package View;

import Model.geralt.Geralt;
import Model.geralt.Spell;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.HashSet;

/**
 * Classe per visualizzare il pannello degli incantesimi di Geralt.
 */
public class SpellsPane extends VBox {

    /**
     * Costruttore per creare il pannello degli incantesimi.
     *
     * @param geralt Il personaggio Geralt di cui visualizzare gli incantesimi.
     */
    public SpellsPane(Geralt geralt) {
        super();
        aggiornaStatistiche(geralt);
    }

    /**
     * Aggiorna il pannello con le statistiche degli incantesimi di Geralt.
     *
     * @param geralt Il personaggio Geralt di cui aggiornare gli incantesimi.
     */
    public void aggiornaStatistiche(Geralt geralt) {
        super.getChildren().clear();
        super.getChildren().add(new Text("Spells: "));
        HashSet<Spell> spells = geralt.getSpells();
        for (Spell s : spells) {
            Text t = new Text(s.toString());
            super.getChildren().add(t);
        }
    }
}
