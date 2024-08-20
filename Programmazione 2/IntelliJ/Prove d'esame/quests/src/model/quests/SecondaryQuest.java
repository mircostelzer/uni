package model.quests;

import model.Geraldo;
import model.enums.NPC;

public class SecondaryQuest extends AbstractQuest{

    protected NPC npc;

    public SecondaryQuest(String no, int lv, int r, NPC nn){
        super(no, lv,  r);
        this.npc = nn;
    }

    protected void addlevel(Geraldo g){
        g.addlevel();
        g.addlevel();
    }

    protected void check_extra_conditions(Geraldo g) {}

    public String getSecondaryInfo() {
        return "NPC: "+this.npc;
    }
}
