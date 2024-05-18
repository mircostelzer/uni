package model.mutations.muts.spells;

import model.exceptions.SpellException;
import model.functions.AddIgni;
import model.functions.MyConsumer;
import model.functions.RemIgni;
import model.geralt.Geralt;
import model.geralt.Mutation;
import model.geralt.Spell;
import model.mutations.abstracts.SpellMutation;

public class IgniSpellMutation extends SpellMutation {

    public IgniSpellMutation(Geralt g) {
        super(Spell.Igni,g, Mutation.Igni);
    }

    @Override
    public MyConsumer<Geralt> applica(){
        return new AddIgni();
    }

    @Override
    public MyConsumer<Geralt> rimuovi(){
        return new RemIgni();
    }
}
