package Model.mutations.muts.potions;

import Model.geralt.Geralt;
import Model.geralt.Mutation;
import Model.mutations.abstracts.PotionMutation;

/**
 * Classe che rappresenta la mutazione della pozione Tolleranza.
 */
public class TolPotionMutation extends PotionMutation {

    /**
     * Costruttore per creare una mutazione della pozione Tolleranza.
     *
     * @param g Il personaggio Geralt a cui la mutazione si applica.
     */
    public TolPotionMutation(Geralt g) {
        super(g, Mutation.Tol);
    }

    /**
     * Applica la mutazione della pozione Tolleranza.
     * Se la mutazione viene aggiunta con successo, aumenta la tolleranza di Geralt di 2.
     */
    @Override
    public void applica() {
        if (g.addMutation(getM())) {
            g.setTolleranza(g.getTolleranza() + 2);
        }
    }

    /**
     * Rimuove la mutazione della pozione Tolleranza.
     * Riduce la tolleranza di Geralt di 2.
     */
    @Override
    public void rimuovi() {
        super.rimuovi();
        g.setTolleranza(g.getTolleranza() - 2);
    }
}