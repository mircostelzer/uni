package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import model.geralt.Geralt;
import model.mutations.abstracts.AbstractMutation;
import view.MainPane;
import view.MutPane;

public class MutationClickHandler implements EventHandler {

    private AbstractMutation am;
    private MainPane m;
    private MutPane mp;

    public MutationClickHandler(AbstractMutation am, MainPane m, MutPane mp){
        this.am = am;
        this.m = m;
        this.mp = mp;
    }

    @Override
    public void handle(Event event) {
        am.clicked();
        m.refresh();
        mp.refresh();
    }
}
