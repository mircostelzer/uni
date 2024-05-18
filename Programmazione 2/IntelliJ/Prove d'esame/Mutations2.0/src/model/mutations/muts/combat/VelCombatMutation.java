package model.mutations.muts.combat;

import model.geralt.Geralt;
import model.functions.*;
import model.geralt.Mutation;
import model.mutations.abstracts.CombatMutation;

public class VelCombatMutation extends CombatMutation {

    public VelCombatMutation(Geralt g){
        super(g, Mutation.Vel);
    }

    @Override
    public MyConsumer<Geralt> applica() {
        return new VelIncr();
    }

    @Override
    public MyConsumer<Geralt> rimuovi() {
        return new VelDecr();
    }
}
