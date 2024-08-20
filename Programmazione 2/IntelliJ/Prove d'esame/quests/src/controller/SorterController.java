package controller;

import model.Geraldo;
import model.comparators.QuestByNameComparator;
import model.comparators.QuestByRicompensaComparator;
import model.quests.Quest;
import view.GeraldoPane;
import view.VQPane;
import java.util.ArrayList;

public class SorterController {

    private VQPane vqp;
    private ArrayList<Quest> aq;

    public SorterController(ArrayList<Quest> a, GeraldoController g){
        this.vqp = new VQPane(g, this);
        this.aq = a;
        this.vqp.redraw(this.aq);
    }

    public VQPane getVqp() { return vqp; }

    public void sortByName(){
        this.aq.sort(new QuestByNameComparator());
        this.vqp.clearQuests();
        this.vqp.redraw(this.aq);
    }

    public void sortByRicompensa(){
        this.aq.sort(new QuestByRicompensaComparator());
        this.vqp.clearQuests();
        this.vqp.redraw(this.aq);
    }

}
