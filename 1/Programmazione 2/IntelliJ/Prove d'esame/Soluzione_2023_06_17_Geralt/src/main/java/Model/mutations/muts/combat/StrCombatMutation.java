package Model.mutations.muts.combat;

import Model.geralt.Geralt;
import Model.geralt.Mutation;
import Model.mutations.abstracts.CombatMutation;

/**
 * Classe che rappresenta la mutazione di combattimento Forza.
 */
public class StrCombatMutation extends CombatMutation {

    /**
     * Costruttore per creare una mutazione di combattimento Forza.
     *
     * @param g Il personaggio Geralt a cui la mutazione si applica.
     */
    public StrCombatMutation(Geralt g) {
        super(g, Mutation.Str);
    }

    /**
     * Applica la mutazione di combattimento Forza.
     * Se la mutazione viene aggiunta con successo, aumenta la forza di Geralt di 2.
     */
    @Override
    public void applica() {
        if (g.addMutation(getM())) {
            g.setForza(g.getForza() + 2);
        }
    }

    /**
     * Rimuove la mutazione di combattimento Forza.
     * Riduce la forza di Geralt di 2.
     */
    @Override
    public void rimuovi() {
        super.rimuovi();
        g.setForza(g.getForza() - 2);
    }
}
