package model.mutations.abstracts;

import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import model.exceptions.AggiuntaException;
import model.functions.MyConsumer;
import model.geralt.Geralt;
import model.geralt.Mutation;
import model.mutations.MutationInterface;

public abstract class AbstractMutation implements MutationInterface {

    protected Geralt g;
    private Mutation m;
    private boolean isequipped = false;

    public AbstractMutation(Geralt g, Mutation m){
        super();
        this.g=g;
        this.m=m;
    }

    public void clicked(){
        MyConsumer m;
        if (this.isequipped) {
            g.removeMutation(this);
            m = this.rimuovi();
        } else {
            try {
                this.addMutation();
            } catch (AggiuntaException e) {
                Alert a =new Alert(Alert.AlertType.INFORMATION, "Cannot add");
                a.show();
            }
            m = this.applica();
        }
        g.applyModifier(m);
        this.isequipped = !this.isequipped;
    }

    public abstract void addMutation() throws AggiuntaException;

    public boolean isEmpty(){
        return this.m == Mutation.Empty;
    }

    public boolean isIsequipped(){
        return this.isequipped;
    }

    public Mutation getMutation(){
        return m;
    }

    public Color getMutationColor(){
        return Color.BLACK;
    }
}
