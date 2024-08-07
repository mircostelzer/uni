package Model.mutations.muts.spells;

import Model.geralt.Geralt;
import Model.geralt.Mutation;
import Model.geralt.Spell;
import Model.mutations.abstracts.SpellMutation;

/**
 * Classe che rappresenta la mutazione dell'incantesimo Igni.
 */
public class IgniSpellMutation extends SpellMutation {

    /**
     * Costruttore per creare una mutazione dell'incantesimo Igni.
     *
     * @param g Il personaggio Geralt a cui la mutazione si applica.
     */
    public IgniSpellMutation(Geralt g) {
        super(g, Mutation.Igni);
    }

    /**
     * Applica la mutazione dell'incantesimo Igni.
     * Se la mutazione viene aggiunta con successo, l'incantesimo Igni viene aggiunto a Geralt.
     */
    @Override
    public void applica() {
        if (g.addMutation(getM())) {
            g.addSpell(Spell.Igni);
        }
    }

    /**
     * Rimuove la mutazione dell'incantesimo Igni.
     * Rimuove l'incantesimo Igni da Geralt.
     */
    @Override
    public void rimuovi() {
        super.rimuovi();
        g.removeSpell(Spell.Igni);
    }
}
