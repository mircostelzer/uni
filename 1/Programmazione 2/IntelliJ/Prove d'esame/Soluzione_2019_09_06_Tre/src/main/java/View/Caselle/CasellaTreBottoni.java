package View.Caselle;

import View.Bottoni.Bottoni;
import View.Casella;
import javafx.scene.layout.HBox;

/**
 * La classe CasellaTreBottoni estende la classe Casella e implementa una casella con tre bottoni.
 */
public class CasellaTreBottoni extends Casella {

    /**
     * Costruisce una nuova CasellaTreBottoni.
     */
    public CasellaTreBottoni() {
        super();
    }

    /**
     * Aggiunge tre bottoni alla casella: il bottone cancella, il bottone cerchio e il bottone triangolo.
     *
     * @param b Un oggetto Bottoni che rappresenta i bottoni da aggiungere alla casella.
     * @return Un HBox contenente i bottoni cancella, cerchio e triangolo.
     */
    @Override
    public HBox aggiungiBottoni(Bottoni b) {
        return new HBox(b.getCancella(), b.getCerchio(), b.getTriangolo());
    }
}
