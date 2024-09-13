package model.mutations.muts.combat;

import model.geralt.Geralt;
import model.functions.*;
import model.geralt.Mutation;
import model.mutations.abstracts.CombatMutation;

public class StrCombatMutation extends CombatMutation {

    public StrCombatMutation(Geralt g){
        super(g, Mutation.Str);
    }

    @Override
    public  MyConsumer<Geralt> applica() {
        return new StrIncr();
    }

    @Override
    public  MyConsumer<Geralt> rimuovi() {
        return new StrDecr();
    }
}
