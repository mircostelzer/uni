package model.mutations.abstracts;

import javafx.scene.paint.Color;
import model.exceptions.AggiuntaException;
import model.geralt.Geralt;
import model.geralt.Mutation;

public abstract class CombatMutation extends AbstractMutation{

    protected CombatMutation(Geralt g, Mutation m){
        super(g,m);
    }

    public void addMutation() throws AggiuntaException {
        g.addCombatMutation(this);
    }

    public Color getMutationColor(){
        return Color.CRIMSON;
    }
}
