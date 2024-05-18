package model.mutations.muts;

import javafx.scene.paint.Color;
import model.exceptions.AggiuntaException;
import model.functions.MyConsumer;
import model.geralt.Geralt;
import model.geralt.Mutation;
import model.mutations.abstracts.AbstractMutation;

public class EmptyMutation extends AbstractMutation {

    public EmptyMutation(){
        super(null, Mutation.Empty);
    }

    public MyConsumer<Geralt> applica() {
        return null;
    }
    public  MyConsumer<Geralt> rimuovi() {
        return null;
    }

    @Override
    public void addMutation() throws AggiuntaException {
        throw new RuntimeException("cannot happen");
    }

    public Color getMutationColor(){
        return Color.GRAY;
    }
}
