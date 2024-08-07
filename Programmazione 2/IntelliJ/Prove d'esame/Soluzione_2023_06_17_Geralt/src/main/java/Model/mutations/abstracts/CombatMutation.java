package Model.mutations.abstracts;

import Model.geralt.Geralt;
import Model.geralt.Mutation;

/**
 * Classe astratta che rappresenta una mutazione di combattimento.
 */
public abstract class CombatMutation extends AbstractMutation {

    /**
     * Costruttore per creare una mutazione di combattimento.
     *
     * @param g Il personaggio Geralt a cui la mutazione si applica.
     * @param m Il tipo di mutazione.
     */
    protected CombatMutation(Geralt g, Mutation m) {
        super(g, m);
    }

    /**
     * Restituisce una rappresentazione in stringa della mutazione di combattimento.
     *
     * @return Stringa che rappresenta la mutazione di combattimento.
     */
    @Override
    public String toString() {
        return "Combat Mutation: " + super.toString();
    }
}
