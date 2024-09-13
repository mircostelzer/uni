package model.quests;

import model.Geraldo;
import model.enums.Mostri;
import java.util.ArrayList;

public class ContractQuest extends AbstractQuest{

    protected ArrayList<Mostri> mostri;

    public ContractQuest(String no, int lv, int r, ArrayList<Mostri> l){
        super(no, lv, r);
        this.mostri = l;
    }

    protected int getReward(){
        return this.reward+(this.reward*2/10);
    }

    protected void check_extra_conditions(Geraldo g) {}

    public String getSecondaryInfo() {
        return "Mostri: "+this.mostri.toString();
    }
}
