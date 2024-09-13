package model.quests;

import model.enums.Luoghi;
import model.enums.Mostri;
import java.util.ArrayList;

public class TreasureHunt extends ContractQuest{

    protected Luoghi luogo;

    public TreasureHunt(String no, int lv, int r, ArrayList<Mostri> m, Luoghi l){
        super(no, lv, r, m);
        this.luogo = l;
    }

    public String getSecondaryInfo() {
        return super.getSecondaryInfo()+"" +
                "\n"+
                "Luogo: "+this.luogo;
    }
}
