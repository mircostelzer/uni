package View.Caselle;

import View.Bottoni.Bottoni;
import View.Casella;
import javafx.scene.layout.HBox;

/**
 * La classe CasellaDueBottoni estende la classe Casella e implementa una casella con due bottoni.
 */
public class CasellaDueBottoni extends Casella {

    /**
     * Costruisce una nuova CasellaDueBottoni.
     */
    public CasellaDueBottoni() {
        super();
    }

    /**
     * Aggiunge due bottoni alla casella: il bottone cancella e il bottone random.
     *
     * @param b Un oggetto Bottoni che rappresenta i bottoni da aggiungere alla casella.
     * @return Un HBox contenente i bottoni cancella e random.
     */
    @Override
    public HBox aggiungiBottoni(Bottoni b) {
        return new HBox(b.getCancella(), b.getRandom());
    }
}
