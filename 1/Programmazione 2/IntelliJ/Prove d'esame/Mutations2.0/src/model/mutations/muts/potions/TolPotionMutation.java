package model.mutations.muts.potions;

import model.geralt.Geralt;
import model.functions.*;
import model.geralt.Mutation;
import model.mutations.abstracts.PotionMutation;

public class TolPotionMutation extends PotionMutation {

    public TolPotionMutation(Geralt g){
        super(g, Mutation.Tol);
    }

    @Override
    public MyConsumer<Geralt> applica() {
        return new TolIncr();
    }

    @Override
    public MyConsumer<Geralt> rimuovi() {
        return new TolDecr();
    }
}
