package Model.mutations.muts.combat;

import Model.geralt.Geralt;
import Model.geralt.Mutation;
import Model.mutations.abstracts.CombatMutation;

/**
 * Classe che rappresenta la mutazione di combattimento Velocità.
 */
public class VelCombatMutation extends CombatMutation {

    /**
     * Costruttore per creare una mutazione di combattimento Velocità.
     *
     * @param g Il personaggio Geralt a cui la mutazione si applica.
     */
    public VelCombatMutation(Geralt g) {
        super(g, Mutation.Vel);
    }

    /**
     * Applica la mutazione di combattimento Velocità.
     * Se la mutazione viene aggiunta con successo, aumenta la velocità di Geralt di 2.
     */
    @Override
    public void applica() {
        if (g.addMutation(getM())) {
            g.setVelocita(g.getVelocita() + 2);
        }
    }

    /**
     * Rimuove la mutazione di combattimento Velocità.
     * Riduce la velocità di Geralt di 2.
     */
    @Override
    public void rimuovi() {
        super.rimuovi();
        g.setVelocita(g.getVelocita() - 2);
    }
}
