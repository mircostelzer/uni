package View;

import Model.geralt.Geralt;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * Classe per visualizzare il pannello delle statistiche di Geralt.
 */
public class StatsPane extends Pane {

    /**
     * Costruttore per creare il pannello delle statistiche.
     *
     * @param geralt Il personaggio Geralt di cui visualizzare le statistiche.
     */
    public StatsPane(Geralt geralt) {
        super();
        creaTesto(geralt);
    }

    /**
     * Crea e aggiorna il testo delle statistiche di Geralt.
     *
     * @param geralt Il personaggio Geralt di cui aggiornare le statistiche.
     */
    public void creaTesto(Geralt geralt) {
        super.getChildren().clear();
        super.getChildren().add(new Text(geralt.stringaStats()));
    }
}
