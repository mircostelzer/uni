package Model.mutations.abstracts;

import Model.geralt.Geralt;
import Model.geralt.Mutation;

/**
 * Classe astratta che rappresenta una mutazione legata alle pozioni.
 */
public abstract class PotionMutation extends AbstractMutation {

    /**
     * Costruttore per creare una mutazione di pozione.
     *
     * @param g Il personaggio Geralt a cui la mutazione si applica.
     * @param m Il tipo di mutazione.
     */
    protected PotionMutation(Geralt g, Mutation m) {
        super(g, m);
    }

    /**
     * Restituisce una rappresentazione in stringa della mutazione di pozione.
     *
     * @return Stringa che rappresenta la mutazione di pozione.
     */
    @Override
    public String toString() {
        return "Potion Mutation: " + super.toString();
    }
}
