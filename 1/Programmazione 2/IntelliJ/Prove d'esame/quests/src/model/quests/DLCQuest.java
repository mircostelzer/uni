package model.quests;

import model.Geraldo;
import model.enums.Luoghi;
import model.exceptions.PreviousQuestNotCompletedException;

public class DLCQuest extends MainQuest{

    protected MainQuest dipendeda;

    public DLCQuest(String no, int lv, Luoghi l, Quest p, MainQuest d){
        super(no,lv,l,p);
        this.dipendeda = d;
    }

    protected void check_extra_conditions(Geraldo g) throws PreviousQuestNotCompletedException {
        super.check_extra_conditions(g);
        if(!this.dipendeda.is_solved()){
            throw new PreviousQuestNotCompletedException();
        }
    }

    public String getSecondaryInfo() {
        return "DLC Req: "+this.dipendeda.getName();
    }
}
