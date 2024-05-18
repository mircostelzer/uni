package model.mutations.muts.spells;

import model.geralt.Geralt;
import model.geralt.Mutation;
import model.geralt.Spell;
import model.exceptions.SpellException;
import model.functions.*;
import model.mutations.abstracts.SpellMutation;

public class QuenSpellMutation extends SpellMutation {

    public QuenSpellMutation(Geralt g) {
        super(Spell.Quen,g, Mutation.Quen);
    }

    @Override
    public MyConsumer<Geralt> applica() {
        return new AddQuen();
    }

    @Override
    public  MyConsumer<Geralt> rimuovi() {
        return new RemQuen();
    }
}
