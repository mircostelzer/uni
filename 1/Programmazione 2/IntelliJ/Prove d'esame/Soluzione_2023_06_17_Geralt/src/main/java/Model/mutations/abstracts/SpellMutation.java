package Model.mutations.abstracts;

import Model.geralt.Geralt;
import Model.geralt.Mutation;

/**
 * Classe astratta che rappresenta una mutazione legata agli incantesimi.
 */
public abstract class SpellMutation extends AbstractMutation {

    /**
     * Costruttore per creare una mutazione di incantesimo.
     *
     * @param g Il personaggio Geralt a cui la mutazione si applica.
     * @param m Il tipo di mutazione.
     */
    protected SpellMutation(Geralt g, Mutation m) {
        super(g, m);
    }

    /**
     * Restituisce una rappresentazione in stringa della mutazione di incantesimo.
     *
     * @return Stringa che rappresenta la mutazione di incantesimo.
     */
    @Override
    public String toString() {
        return "Spell Mutation: " + super.toString();
    }
}
