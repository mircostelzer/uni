package Model.mutations.muts.spells;

import Model.geralt.Geralt;
import Model.geralt.Mutation;
import Model.geralt.Spell;
import Model.mutations.abstracts.SpellMutation;

/**
 * Classe che rappresenta la mutazione dell'incantesimo Quen.
 */
public class QuenSpellMutation extends SpellMutation {

    /**
     * Costruttore per creare una mutazione dell'incantesimo Quen.
     *
     * @param g Il personaggio Geralt a cui la mutazione si applica.
     */
    public QuenSpellMutation(Geralt g) {
        super(g, Mutation.Quen);
    }

    /**
     * Applica la mutazione dell'incantesimo Quen.
     * Se la mutazione viene aggiunta con successo, l'incantesimo Quen viene aggiunto a Geralt.
     */
    @Override
    public void applica() {
        if (g.addMutation(getM())) {
            g.addSpell(Spell.Quen);
        }
    }

    /**
     * Rimuove la mutazione dell'incantesimo Quen.
     * Rimuove l'incantesimo Quen da Geralt.
     */
    @Override
    public void rimuovi() {
        super.rimuovi();
        g.removeSpell(Spell.Quen);
    }
}
