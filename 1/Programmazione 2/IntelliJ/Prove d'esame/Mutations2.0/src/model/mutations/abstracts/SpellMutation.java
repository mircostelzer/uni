package model.mutations.abstracts;

import javafx.scene.paint.Color;
import model.exceptions.AggiuntaException;
import model.geralt.Geralt;
import model.geralt.Mutation;
import model.geralt.Spell;

public abstract class SpellMutation extends AbstractMutation{
    Spell s;

    protected SpellMutation(Spell s, Geralt g, Mutation m){
        super(g,m);
        this.s=s;
    }

    public void addMutation() throws AggiuntaException {
        g.addSpellMutation( this);
    }

    public Color getMutationColor(){
        return Color.CADETBLUE;
    }
}
