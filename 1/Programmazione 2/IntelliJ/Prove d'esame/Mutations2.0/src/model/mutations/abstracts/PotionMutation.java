package model.mutations.abstracts;

import javafx.scene.paint.Color;
import model.exceptions.AggiuntaException;
import model.geralt.Geralt;
import model.geralt.Mutation;

public abstract class PotionMutation extends AbstractMutation{

    protected PotionMutation(Geralt g, Mutation m){
        super(g,m);
    }

    public void addMutation() throws AggiuntaException {
        g.addPotionMutation(this);
    }

    public Color getMutationColor(){
        return Color.GREENYELLOW;
    }
}
