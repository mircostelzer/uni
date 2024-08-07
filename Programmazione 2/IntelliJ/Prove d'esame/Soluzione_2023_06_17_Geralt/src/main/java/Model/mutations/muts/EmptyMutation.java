package Model.mutations.muts;

import Model.geralt.Geralt;
import Model.geralt.Mutation;
import Model.mutations.abstracts.AbstractMutation;

/**
 * Classe che rappresenta una mutazione vuota.
 */
public class EmptyMutation extends AbstractMutation {

    /**
     * Costruttore per creare una mutazione vuota.
     *
     * @param g Il personaggio Geralt a cui la mutazione si applica.
     * @param m Il tipo di mutazione.
     */
    protected EmptyMutation(Geralt g, Mutation m) {
        super(g, m);
    }

    /**
     * Applica la mutazione vuota.
     * Questa implementazione non esegue alcuna operazione.
     */
    @Override
    public void applica() {
        // Nessuna operazione per la mutazione vuota
    }

    /**
     * Rimuove la mutazione vuota.
     * Questa implementazione non esegue alcuna operazione.
     */
    @Override
    public void rimuovi() {
        // Nessuna operazione per la mutazione vuota
    }
}
