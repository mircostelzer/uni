package Model.mutations.abstracts;

import Model.geralt.Geralt;
import Model.geralt.Mutation;
import Model.mutations.MutationInterface;

/**
 * Classe astratta che rappresenta una mutazione e implementa l'interfaccia MutationInterface.
 * Fornisce l'implementazione base per le mutazioni specifiche.
 */
public abstract class AbstractMutation implements MutationInterface {
    private final Mutation m;
    protected Geralt g;

    /**
     * Costruttore per creare una mutazione astratta.
     *
     * @param g Il personaggio Geralt a cui la mutazione si applica.
     * @param m Il tipo di mutazione.
     */
    protected AbstractMutation(Geralt g, Mutation m) {
        super();
        this.m = m;
        this.g = g;
    }

    /**
     * Restituisce il tipo di mutazione.
     *
     * @return Il tipo di mutazione.
     */
    public Mutation getM() {
        return m;
    }

    /**
     * Rimuove la mutazione dal personaggio Geralt.
     */
    @Override
    public void rimuovi() {
        g.removeMutation(m);
    }

    /**
     * Restituisce una rappresentazione in stringa della mutazione.
     *
     * @return Stringa che rappresenta la mutazione.
     */
    @Override
    public String toString() {
        return m.toString();
    }
}
